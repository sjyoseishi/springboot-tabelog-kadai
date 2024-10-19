package com.example.nagoyameshi.controller;

 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;
 import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.nagoyameshi.form.StoreRegisterForm;
import com.example.nagoyameshi.entity.Category;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.annotation.Validated;
import com.example.nagoyameshi.form.StoreEditForm;

import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.service.StoreService;


@Controller
@RequestMapping("/admin/stores")
public class AdminStoreController {

	private final StoreRepository storeRepository;
	private final CategoryRepository categoryRepository;
	private final StoreService storeService;

    public AdminStoreController(StoreRepository storeRepository, CategoryRepository categoryRepository, StoreService storeService) {
        this.storeRepository = storeRepository;
        this.categoryRepository = categoryRepository;
        this.storeService = storeService;
    }

    @GetMapping

    public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam(name = "keyword", required = false) String keyword) {

    	Page<Store> storePage;

        if (keyword != null && !keyword.isEmpty()) {
        	storePage = storeRepository.findByNameLike("%" + keyword + "%", pageable);
        } else {
        	storePage = storeRepository.findAll(pageable);
        }

        model.addAttribute("storePage", storePage);
        model.addAttribute("keyword", keyword);

        return "admin/stores/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable(name = "id") Integer id, Model model) {
    	Store store = storeRepository.getReferenceById(id);

        model.addAttribute("store", store);

        return "admin/stores/show";
    }

    @GetMapping("/register")
    public String register(Model model) {
    	List<Category> category = categoryRepository.findAll();

        model.addAttribute("storeRegisterForm", new StoreRegisterForm());
        model.addAttribute("category", category);

        return "admin/stores/register";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated StoreRegisterForm storeRegisterForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "admin/stores/register";
        }

        storeService.create(storeRegisterForm);
        redirectAttributes.addFlashAttribute("successMessage", "店舗を登録しました。");

        return "redirect:/admin/stores";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(name = "id") Integer id, Model model) {
    	Store store = storeRepository.getReferenceById(id);
        String imageName = store.getImageName();
        StoreEditForm storeEditForm = new StoreEditForm(store.getId(), store.getName(), null, store.getDescription(), store.getPriceFloor(), store.getPriceCap(), store.getOpeningTime(), store.getClosingTime(),store.getSeatingCapacity(), store.getPostalCode(), store.getAddress(), store.getPhoneNumber(),store.getRegularHoliday(), store.getCategory());
    	List<Category> category = categoryRepository.findAll();

        model.addAttribute("imageName", imageName);
        model.addAttribute("storeEditForm", storeEditForm);
        model.addAttribute("category", category);


        return "admin/stores/edit";
    }

    @PostMapping("/{id}/update")
    public String update(@ModelAttribute @Validated StoreEditForm storeEditForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "admin/stores/edit";
        }

        storeService.update(storeEditForm);
        redirectAttributes.addFlashAttribute("successMessage", "店舗情報を編集しました。");

        return "redirect:/admin/stores";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
    	storeRepository.deleteById(id);

        redirectAttributes.addFlashAttribute("successMessage", "店舗を削除しました。");

        return "redirect:/admin/stores";
    }
}
