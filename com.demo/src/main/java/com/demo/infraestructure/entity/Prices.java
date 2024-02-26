package com.demo.infraestructure.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.demo.infraestructure.enums.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRICES")
public class Prices {

	@Id
	@Column(name = "BRAND_ID", unique = true, nullable = false)
	private Integer brandId;

	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "PRICE_LIST")
	private Integer pricelist;
	
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	
	@Column(name = "PRIORITY")
	private boolean priority;
	
	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURR")
	@Enumerated(EnumType.STRING)
	private Currency currency;
	
	
}
