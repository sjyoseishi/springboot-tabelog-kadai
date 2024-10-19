package com.example.nagoyameshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.example.nagoyameshi.service.ReviewService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort.Direction;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.security.UserDetailsImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.form.EditForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.nagoyameshi.form.RegisterForm;
import com.example.nagoyameshi.entity.User;


@Controller
@RequestMapping("/stores/{storeId}/review")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final ReviewService reviewService;

    public ReviewController(ReviewRepository reviewRepository,StoreRepository storeRepository,ReviewService reviewService) {
	    this.reviewRepository = reviewRepository;
	    this.storeRepository = storeRepository;
	    this.reviewService = reviewService;


    }

	 //店舗詳細
	 @GetMapping
	  public String index(Model model,@PageableDefault(page = 0, size = 6, sort = "id", direction = Direction.ASC)Pageable pageable) {
		   Page<Review> reviewPage;
		   reviewPage = reviewRepository.findAll(pageable);
		   model.addAttribute("reviewPage", reviewPage);
		   return "stores/show";
	  }

	 //レビュー一覧の表示
	 @GetMapping("/reviews")
	  public String reviews(@PathVariable(name = "storeId") Integer storeId,Model model,@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC)Pageable pageable) {

		  Store store = storeRepository.getReferenceById(storeId);
		  Page<Review> reviewPage = reviewRepository.findByStoreOrderByCreatedAtDesc(store, pageable);
		  model.addAttribute("store", store);
	      model.addAttribute("reviewPage", reviewPage);
	      return "review/reviews";
	  }

		//レビューの編集
     @GetMapping("/{id}/edit")
     public String edit(@PathVariable(name = "id") Integer id, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl,@PathVariable(name = "storeId") Integer storeId, Model model) {
    	 Store store = storeRepository.getReferenceById(storeId);
         Review review = reviewRepository.getReferenceById(id);
         EditForm EditForm = new EditForm(review.getId(),store.getId(),review.getStar(), review.getReview());

         model.addAttribute("store", store);
         model.addAttribute("EditForm", EditForm);


         return "review/edit";
     }

	  //レビューの更新
	  @PostMapping("/{id}/update")
	  public String update(@ModelAttribute@Validated EditForm EditForm, BindingResult bindingResult,@PathVariable(name = "storeId") Integer storeId, Model model, RedirectAttributes redirectAttributes) {
		   if(bindingResult.hasErrors()) {
			   return "review/edit";
		   }
		   Store store = storeRepository.getReferenceById(storeId);
		   model.addAttribute("store", store);
		   reviewService.update(EditForm);
		   redirectAttributes.addFlashAttribute("successMessage", "レビューを編集しました。");
		   return "redirect:/stores/{storeId}";

	  }

	  //レビューの投稿
	  @GetMapping("/register")
	  public String register(@PathVariable(name = "storeId") Integer storeId, Model model) {
		  Store store = storeRepository.getReferenceById(storeId);
	      model.addAttribute("store", store);
	      model.addAttribute("RegisterForm", new RegisterForm());
	      return "review/register";
	  }

	  //レビューの作成
	  @PostMapping("/create")
	  public String create(@PathVariable(name = "storeId") Integer storeId, @ModelAttribute @Validated RegisterForm registerForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		   if(bindingResult.hasErrors()) {
			   return "stores/show/review/register";
		   }
		   User user = userDetailsImpl.getUser();
		   reviewService.create(registerForm, user);
		   redirectAttributes.addFlashAttribute("successMessage", "レビューを登録しました。");
		   return "redirect:/stores/{storeId}";

	  }
	  //レビューの削除
	  @GetMapping("/{id}/delete")
	  public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
		   reviewRepository.deleteById(id);
		   redirectAttributes.addFlashAttribute("successMessage", "レビューを削除しました。");
		   return "redirect:/stores/{storeId}";
	  }

}
