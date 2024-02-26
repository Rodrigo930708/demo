package com.demo.application.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class PricesResponse {

	private Integer productId;
	private Integer group;
	private BigDecimal price;
	private Date startDate;
	private Date endDate;
}
