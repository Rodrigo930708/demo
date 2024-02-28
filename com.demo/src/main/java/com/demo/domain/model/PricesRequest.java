package com.demo.domain.model;

import java.io.Serializable;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class PricesRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String date;
	private Integer productId;
	private Integer group;
	
	
}
