package com.example.nagoyameshi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.nagoyameshi.form.StoreCancelForm;

import com.example.nagoyameshi.entity.Reservation;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReservationInputForm;
import com.example.nagoyameshi.form.ReservationRegisterForm;
import com.example.nagoyameshi.repository.ReservationRepository;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.service.ReservationService;
import com.example.nagoyameshi.repository.UserRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;


@Controller
public class ReservationController {

    private final ReservationRepository reservationRepository;
	private final StoreRepository storeRepository;
	private final ReservationService reservationService;
	private final UserRepository userRepository;
	private final ReviewRepository reviewRepository;

    public ReservationController(ReservationRepository reservationRepository, StoreRepository storeRepository, ReservationService reservationService, UserRepository userRepository, ReviewRepository reviewRepository) {
        this.reservationRepository = reservationRepository;
		this.storeRepository = storeRepository;
		this.reservationService = reservationService;
		this.userRepository = userRepository;
		this.reviewRepository = reviewRepository;
    }

    @GetMapping("/reservations")
    public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, RedirectAttributes redirectAttributes, Model model) {
        User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		if ("ROLE_FREE_MEMBER".equals(user.getRole().getName())) {
			redirectAttributes.addFlashAttribute("subscriptionMessage", "この機能は有料プランに加入しないと使用できません");
			return "redirect:/subscription/register";
		}
        Page<Reservation> reservationPage = reservationRepository.findByUserOrderByCreatedAtDesc(user, pageable);

        model.addAttribute("reservationPage", reservationPage);
		model.addAttribute("storeCancelForm", new StoreCancelForm());
		model.addAttribute("now", LocalDateTime.now());

        return "reservations/index";
    }

    @GetMapping("/stores/{id}/reservations/input")
	public String input(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id,
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Direction.ASC) Pageable pageable,
			@ModelAttribute @Validated ReservationInputForm reservationInputForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			Model model) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());

		if ("ROLE_FREE_MEMBER".equals(user.getRole().getName())) {
			redirectAttributes.addFlashAttribute("subscriptionMessage", "この機能は有料プランに加入しないと使用できません");
			return "redirect:/subscription/register";
		}

		Store store = storeRepository.getReferenceById(id);

		Integer count = reservationInputForm.getCount();
		Integer capacity = store.getSeatingCapacity();

		if (count != null) {
			if (!reservationService.isWithinCapacity(count, capacity)) {
				FieldError fieldError = new FieldError(bindingResult.getObjectName(), "count",
						"予約人数が定員を超えています。");
				bindingResult.addError(fieldError);
			}
		}

		String reservationDate = reservationInputForm.getReservationDate();
		String reservationTime = reservationInputForm.getReservationTime();

		if (!reservationDate.isEmpty() && !reservationTime.isEmpty()) {
			if (!reservationService.isReservationDateWhenCurrentTimeAfter(reservationDate, reservationTime)) {
				FieldError fieldError = new FieldError(bindingResult.getObjectName(), "reservationTime",
						"予約時間を過ぎています。");
				bindingResult.addError(fieldError);
			}
		}

		if (bindingResult.hasErrors()) {
			Page<Review> reviewPage = reviewRepository.findByStoreIdOrderByReviewDescCreatedAtDesc(id, pageable);


			model.addAttribute("store", store);
			model.addAttribute("errorMessage", "予約内容に不備があります。");
			model.addAttribute("reviewPage", reviewPage);
			return "stores/show";
		}

		redirectAttributes.addFlashAttribute("reservationInputForm", reservationInputForm);

		return "redirect:/stores/{id}/reservations/confirm";
	}

    @GetMapping("/stores/{id}/reservations/confirm")
	public String confirm(@PathVariable(name = "id") Integer id,
			@ModelAttribute ReservationInputForm reservationInputForm,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, RedirectAttributes redirectAttributes,
			Model model) {
		Store store = storeRepository.getReferenceById(id);
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		if ("ROLE_FREE_MEMBER".equals(user.getRole().getName())) {
			redirectAttributes.addFlashAttribute("subscriptionMessage", "この機能は有料プランに加入しないと使用できません");
			return "redirect:/subscription/register";
		}

		//予約日時を取得する
		LocalDateTime reservationDateTime = LocalDateTime
				.parse(reservationInputForm.getReservationDate() + "T" + reservationInputForm.getReservationTime());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 H時mm分");

		ReservationRegisterForm reservationRegisterForm = new ReservationRegisterForm(user.getId(), store.getId(),
				reservationDateTime.format(dtf), reservationInputForm.getCount());

		model.addAttribute("store", store);
		model.addAttribute("reservationRegisterForm", reservationRegisterForm);

		return "reservations/confirm";
	}

	@PostMapping("/stores/{id}/reservations/create")
	public String create(@ModelAttribute ReservationRegisterForm reservationRegisterForm) {
		reservationService.create(reservationRegisterForm);
		return "redirect:/reservations?reserved";
	}

	@PostMapping("/stores/cancel")
	public String cancel(@ModelAttribute StoreCancelForm storeCancelForm,
			RedirectAttributes redirectAttributes) {
		reservationService.cancel(storeCancelForm);
		redirectAttributes.addFlashAttribute("successMessage", "予約のキャンセルが完了しました。");
		return "redirect:/reservations";
	}

}
