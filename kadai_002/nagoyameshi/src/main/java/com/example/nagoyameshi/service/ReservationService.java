package com.example.nagoyameshi.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Reservation;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReservationRegisterForm;
import com.example.nagoyameshi.form.StoreCancelForm;
import com.example.nagoyameshi.repository.ReservationRepository;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.repository.UserRepository;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final StoreRepository storeRepository;
	private final UserRepository userRepository;

	public ReservationService(ReservationRepository reservationRepository, StoreRepository storeRepository,
			UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.storeRepository = storeRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		Store store = storeRepository.getReferenceById(reservationRegisterForm.getStoreId());
		User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());
		DateTimeFormatter dtFt = DateTimeFormatter.ofPattern("yyyy年MM月dd日 H時mm分");
		LocalDateTime reservationDate = LocalDateTime.parse(reservationRegisterForm.getReservationDateTime(), dtFt);

		reservation.setStore(store);
		reservation.setUser(user);
		reservation.setReservationDateTime(reservationDate);
		reservation.setCount(reservationRegisterForm.getCount());

		reservationRepository.save(reservation);
	}

	@Transactional
	public void cancel(StoreCancelForm storeCancelForm) {
		reservationRepository.deleteById(storeCancelForm.getId());
	}

	// 予約人数が定員以下かどうかをチェックする
	public boolean isWithinCapacity(Integer count, Integer capacity) {
		return count <= capacity;
	}

	// 予約日時が現在時刻以降かをチェックする
	public boolean isReservationDateWhenCurrentTimeAfter(String reservationDate, String reservationTime) {
		LocalDateTime reservation = LocalDateTime.parse(reservationDate + "T" + reservationTime);
		LocalDateTime now = LocalDateTime.now();
		return reservation.isAfter(now);
	}

}