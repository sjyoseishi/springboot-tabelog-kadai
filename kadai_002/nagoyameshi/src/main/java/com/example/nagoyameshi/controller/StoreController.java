package com.example.nagoyameshi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.example.nagoyameshi.form.ReservationInputForm;

import com.example.nagoyameshi.entity.Category;
import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.FavoriteRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.FavoriteService;
import com.example.nagoyameshi.service.ReviewService;

@Controller
@RequestMapping("/stores")

public class StoreController {

    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;
    private final FavoriteService favoriteService;
    private final FavoriteRepository favoriteRepository;

    public StoreController(StoreRepository storeRepository, CategoryRepository categoryRepository, ReviewRepository reviewRepository, ReviewService reviewService, FavoriteService favoriteService, FavoriteRepository favoriteRepository) {
        this.storeRepository = storeRepository;
        this.categoryRepository = categoryRepository;
        this.reviewRepository = reviewRepository;
        this.reviewService = reviewService;
        this.favoriteService = favoriteService;
        this.favoriteRepository = favoriteRepository;
    }

    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword,
                        @RequestParam(name = "category", required = false) Integer category,
                        @RequestParam(name = "price", required = false) Integer price,
                        @RequestParam(name = "order", required = false) String order,
                        @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
                        Model model)
    {
        Page<Store> storePage;

		if (keyword != null && !keyword.isEmpty()) {
			if (order != null && order.equals("priceAsc")) {
				storePage = storeRepository.findByNameLikeOrAddressLikeOrCategoryNameLikeOrderByPriceFloorAsc(
						"%" + keyword + "%",
						"%" + keyword + "%", "%" + keyword + "%", pageable);
			} else {
				storePage = storeRepository
						.findByNameLikeOrAddressLikeOrCategoryNameLikeOrderByCreatedAtDesc(
								"%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%", pageable);
			}
		} else if (price != null) {
			if (order != null && order.equals("priceAsc")) {
				storePage = storeRepository.findByPriceFloorLessThanEqualOrderByPriceFloorAsc(price, pageable);
			} else {
				storePage = storeRepository.findByPriceFloorLessThanEqualOrderByCreatedAtDesc(price, pageable);
			}
		} else if (category != null) {
			if (order != null && order.equals("priceAsc")) {
				storePage = storeRepository.findByCategoryIdOrderByPriceFloorAsc(category, pageable);
			} else {
				storePage = storeRepository.findByCategoryIdOrderByCreatedAtDesc(category, pageable);
			}
		} else {
			if (order != null && order.equals("priceAsc")) {
				storePage = storeRepository.findAllByOrderByPriceFloorAsc(pageable);
			} else {
				storePage = storeRepository.findAllByOrderByCreatedAtDesc(pageable);
			}
		}
		List<Category> categoryList = categoryRepository.findAll();


		model.addAttribute("storePage", storePage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("price", price);
		model.addAttribute("order", order);
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryList);

        return "stores/index";
    }

    @GetMapping("/{id}")
    public String show(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, Model model) {
    	Store store = storeRepository.getReferenceById(id);
    	List<Review> reviewPage = reviewRepository.findTop6ByStoreOrderByCreatedAtDesc(store);
    	long reviewCount = reviewRepository.countByStore(store);
        boolean isFavorite = false;
        boolean hasUserAlreadyReviewed = false;
        Favorite favorite = null;


        if (userDetailsImpl != null) {
            User user = userDetailsImpl.getUser();
            hasUserAlreadyReviewed = reviewService.hasUserAlreadyReviewed(store, user);
            isFavorite = favoriteService.isFavorite(store, user);
            if (isFavorite) {
                favorite = favoriteRepository.findByStoreAndUser(store, user);
            }
        }


        model.addAttribute("store", store);
        model.addAttribute("reviewPage", reviewPage);
        model.addAttribute("reviewCount", reviewCount);
        model.addAttribute("isFavorite", isFavorite);
        model.addAttribute("hasUserAlreadyReviewed", hasUserAlreadyReviewed);
        model.addAttribute("favorite", favorite);
        model.addAttribute("reservationInputForm", new ReservationInputForm());

        return "stores/show";
    }
}
