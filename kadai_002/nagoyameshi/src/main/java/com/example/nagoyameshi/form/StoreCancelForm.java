package com.example.nagoyameshi.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StoreCancelForm {
	@NotNull
    private Integer id;
}
