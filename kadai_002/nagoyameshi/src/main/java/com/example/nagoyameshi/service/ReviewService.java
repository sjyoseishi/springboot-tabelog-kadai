package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;

import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.nagoyameshi.form.EditForm;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.form.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;




@Service
public class ReviewService {

	@Autowired
	private final ReviewRepository reviewRepository;
	private final StoreRepository storeRepository;




	public ReviewService(ReviewRepository reviewRepository, StoreRepository storeRepository) {
		this.reviewRepository = reviewRepository;
		this.storeRepository = storeRepository;

	}

	//レビューの更新
	@Transactional
	public void update(EditForm EditForm) {
		Review review = reviewRepository.getReferenceById(EditForm.getId());
		review.setStar(EditForm.getStar());
		review.setReview(EditForm.getReview());
		reviewRepository.save(review);
	}

	//新規レビューをDBに保存
	@Transactional
	public void create(RegisterForm RegisterForm, User user) {
		Review review = new Review();
		Store store = storeRepository.getReferenceById(RegisterForm.getStoreId());
		review.setStore(store);
		review.setUser(user);
		review.setStar(RegisterForm.getStar());
		review.setReview(RegisterForm.getReview());
		reviewRepository.save(review);
	}

    public boolean hasUserAlreadyReviewed(Store store, User user) {
        return reviewRepository.findByStoreAndUser(store, user) != null;
    }

}
