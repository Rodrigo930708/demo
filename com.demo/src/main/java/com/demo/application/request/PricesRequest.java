package com.demo.application.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class PricesRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String fecha;
	private Integer productId;
	private Integer group;
	
	
}
