package com.demo.infrastructure.rest.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.domain.model.PricesResponse;
import com.demo.infrastructure.entity.Prices;
import com.demo.infrastructure.rest.exceptions.MalformedException;

public class Mapper {
	
	public static Date convertStringDate(String date) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateResponse;
		try {
			dateResponse = formatter.parse(date);
		} catch (ParseException e) {

			 throw new MalformedException();
		}
		return dateResponse;
		
	}
	
	public static PricesResponse convertResponse(Prices prices) {
	
		PricesResponse response = new PricesResponse();
		
		response.setProductId(prices.getProductId());
		response.setPrice(prices.getPrice());
		response.setGroup(prices.getBrandId());
		response.setStartDate(prices.getStartDate());
		response.setEndDate(prices.getEndDate());
		
		return response;
	}


}
