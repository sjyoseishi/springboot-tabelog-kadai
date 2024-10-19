package com.example.nagoyameshi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.FavoriteRepository;

@Service
public class FavoriteService {
	private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Transactional
    public void create(Store store, User user) {
    	Favorite favorite = new Favorite();
		favorite.setUser(user);
		favorite.setStore(store);
		favoriteRepository.save(favorite);
    }

    @Transactional
    public void delete(Store store, User user) {

    	List<Favorite> favorites = favoriteRepository.findByUserIdAndStoreIdOrderByCreatedAtDesc(user.getId(), store.getId());

    	favoriteRepository.deleteAll(favorites);
    }

    public boolean isFavorite(Store store, User user) {
        return favoriteRepository.findByStoreAndUser(store, user) != null;
    }
}



