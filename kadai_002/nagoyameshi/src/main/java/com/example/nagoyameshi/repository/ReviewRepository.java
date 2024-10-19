package com.example.nagoyameshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

	public Page<Review>findByStoreOrderByCreatedAtDesc(Store store, Pageable pageable);

    // 特定の店舗IDに基づいたレビューリストを取得するためのメソッド
	public List<Review> findTop6ByStoreOrderByCreatedAtDesc(Store store); /*最新の6件を取得*/

	public Review findByStoreAndUser(Store store, User user);

	public Page<Review> findByStoreIdOrderByReviewDescCreatedAtDesc(Integer storeId, Pageable pageable);

	long countByStore(Store store);

}
