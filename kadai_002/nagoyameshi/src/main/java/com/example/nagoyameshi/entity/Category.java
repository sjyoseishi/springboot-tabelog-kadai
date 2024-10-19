package com.example.nagoyameshi.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Table(name = "categorys")
@Data
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

	@Column(name = "name")
	private String name;

	@CreationTimestamp
	@Column(name = "created_at")
	private Timestamp createdAt;

	@CreationTimestamp
	@Column(name = "updated_at")
	private Timestamp updatedAt;

}
