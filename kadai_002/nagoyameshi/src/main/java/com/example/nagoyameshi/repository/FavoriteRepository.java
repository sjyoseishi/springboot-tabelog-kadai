package com.example.nagoyameshi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    public Page<Favorite> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
    public Favorite findByStoreAndUser(Store store, User user);
    public List<Favorite> findByUserIdAndStoreIdOrderByCreatedAtDesc(Integer userId, Integer storeId);
}
