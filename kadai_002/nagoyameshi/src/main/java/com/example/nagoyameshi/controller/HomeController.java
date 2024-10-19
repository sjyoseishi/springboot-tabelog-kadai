package com.example.nagoyameshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.ui.Model;

import com.example.nagoyameshi.entity.Category;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.StoreRepository;

@Controller
public class HomeController {
    private final StoreRepository StoreRepository;
    private final CategoryRepository categoryRepository;

    public HomeController(StoreRepository StoreRepository, CategoryRepository categoryRepository) {
        this.StoreRepository = StoreRepository;
        this.categoryRepository = categoryRepository;
    }



    @GetMapping("/")
    public String index(Model model) {
        List<Store> newStores = StoreRepository.findTop10ByOrderByCreatedAtDesc();
        List<Category> categories = categoryRepository.findAll();

        model.addAttribute("newStores", newStores);
        model.addAttribute("categories", categories);

        return "index";
    }
}
