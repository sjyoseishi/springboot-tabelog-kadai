package com.example.nagoyameshi.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationRegisterForm {

	private Integer userId;

	private Integer storeId;

	private String reservationDateTime;

	private Integer count;
}