package com.example.nagoyameshi.form;

import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FavoriteRegisterForm {

	@NotNull
	private Integer storeId;

	@NotNull
	private Integer userId;


	@Transactional
	public void deleteByStoreIdAndUserId(Integer storeId, Integer userId) {
		this.storeId = storeId;
		this.userId = userId;
	}
}