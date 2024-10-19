package com.example.nagoyameshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.nagoyameshi.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>{



	public Page<Category> findByNameLike(String Keyword, Pageable pageable);



}
