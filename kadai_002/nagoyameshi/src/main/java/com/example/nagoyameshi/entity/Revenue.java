package com.example.nagoyameshi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Revenue {

	@Id
    private Integer id;

    private String item;

    private long revenue;
}