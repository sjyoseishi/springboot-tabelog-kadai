package com.example.nagoyameshi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import com.example.nagoyameshi.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer>{
	public Page<Store> findByNameLike(String keyword, Pageable pageable);



	public Page<Store> findByNameLikeOrAddressLikeOrCategoryNameLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword, String categoryKeyword, Pageable pageable);
    public Page<Store> findByNameLikeOrAddressLikeOrCategoryNameLikeOrderByPriceFloorAsc(String nameKeyword, String addressKeyword, String categoryKeyword, Pageable pageable);
    public Page<Store> findByPriceFloorLessThanEqualOrderByCreatedAtDesc(Integer price, Pageable pageable);
    public Page<Store> findByPriceFloorLessThanEqualOrderByPriceFloorAsc(Integer price, Pageable pageable);
    public Page<Store> findByCategoryIdOrderByCreatedAtDesc(Integer category, Pageable pageable);
    public Page<Store> findByCategoryIdOrderByPriceFloorAsc(Integer category, Pageable pageable);
    public Page<Store> findAllByOrderByCreatedAtDesc(Pageable pageable);
    public Page<Store> findAllByOrderByPriceFloorAsc(Pageable pageable);

    public List<Store> findTop10ByOrderByCreatedAtDesc();

	public List<Store> findByCategoryId(Integer categoryId);








}
