package com.example.nagoyameshi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.example.nagoyameshi.form.StoreEditForm;

import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.form.StoreRegisterForm;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.StoreRepository;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;

    public StoreService(StoreRepository storeRepository, CategoryRepository categoryRepository) {
        this.storeRepository = storeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void create(StoreRegisterForm storeRegisterForm) {
    	Store store = new Store();
        MultipartFile imageFile = storeRegisterForm.getImageFile();

        if (!imageFile.isEmpty()) {
            String imageName = imageFile.getOriginalFilename();
            String hashedImageName = generateNewFileName(imageName);
            Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
            copyImageFile(imageFile, filePath);
            store.setImageName(hashedImageName);
        }

        store.setName(storeRegisterForm.getName());
        store.setDescription(storeRegisterForm.getDescription());
        store.setPriceFloor(storeRegisterForm.getPriceFloor());
        store.setPriceCap(storeRegisterForm.getPriceCap());
        store.setOpeningTime(storeRegisterForm.getOpeningTime());
        store.setClosingTime(storeRegisterForm.getClosingTime());
        store.setPostalCode(storeRegisterForm.getPostalCode());
        store.setAddress(storeRegisterForm.getAddress());
        store.setPhoneNumber(storeRegisterForm.getPhoneNumber());
        store.setRegularHoliday(storeRegisterForm.getRegularHoliday());
        store.setCategory(categoryRepository.getReferenceById(storeRegisterForm.getCategory()));

        storeRepository.save(store);
    }

    @Transactional
    public void update(StoreEditForm storeEditForm) {
    	Store store = storeRepository.getReferenceById(storeEditForm.getId());
        MultipartFile imageFile = storeEditForm.getImageFile();

        if (!imageFile.isEmpty()) {
            String imageName = imageFile.getOriginalFilename();
            String hashedImageName = generateNewFileName(imageName);
            Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
            copyImageFile(imageFile, filePath);
            store.setImageName(hashedImageName);
        }

        store.setName(storeEditForm.getName());
        store.setDescription(storeEditForm.getDescription());
        store.setPriceFloor(storeEditForm.getPriceFloor());
        store.setPriceCap(storeEditForm.getPriceCap());
        store.setOpeningTime(storeEditForm.getOpeningTime());
        store.setClosingTime(storeEditForm.getClosingTime());
        store.setPostalCode(storeEditForm.getPostalCode());
        store.setAddress(storeEditForm.getAddress());
        store.setPhoneNumber(storeEditForm.getPhoneNumber());
        store.setRegularHoliday(storeEditForm.getRegularHoliday());
        store.setCategory(storeEditForm.getCategory());

        storeRepository.save(store);
    }

    // UUIDを使って生成したファイル名を返す
    public String generateNewFileName(String fileName) {
        String[] fileNames = fileName.split("\\.");
        for (int i = 0; i < fileNames.length - 1; i++) {
            fileNames[i] = UUID.randomUUID().toString();
        }
        String hashedFileName = String.join(".", fileNames);
        return hashedFileName;
    }

    // 画像ファイルを指定したファイルにコピーする
    public void copyImageFile(MultipartFile imageFile, Path filePath) {
        try {
            Files.copy(imageFile.getInputStream(), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
