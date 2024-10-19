package com.example.nagoyameshi.form;

import java.time.LocalTime;

import org.springframework.web.multipart.MultipartFile;

import com.example.nagoyameshi.entity.Category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreEditForm {
	@NotNull
	private Integer id;

    @NotBlank(message = "店舗名を入力してください。")
    private String name;

    private MultipartFile imageFile;

    @NotBlank(message = "説明を入力してください。")
    private String description;

    @NotNull(message = "価格下限を入力してください。")
    @Min(value = 1, message = "価格下限は1円以上に設定してください。")
    private Integer priceFloor;

    @NotNull(message = "価格上限を入力してください。")
    @Min(value = 1, message = "価格上限は価格下限以上の金額を設定してください。")
    private Integer priceCap;

    @NotNull(message = "開店時間を入力してください。")
    private LocalTime openingTime;

    @NotNull(message = "閉店時間を入力してください。")
    private LocalTime closingTime;

    @NotNull(message = "座席数を入力してください。")
    @Min(value = 1, message = "座席数は1人以上に設定してください。")
    private Integer seatingCapacity;

    @NotBlank(message = "郵便番号を入力してください。")
    private String postalCode;

    @NotBlank(message = "住所を入力してください。")
    private String address;

    @NotBlank(message = "電話番号を入力してください。")
    private String phoneNumber;

    @NotBlank(message = "定休日を入力してください。")
    private String regularHoliday;

    private Category category;

}
