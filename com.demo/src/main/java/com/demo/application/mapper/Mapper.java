package com.demo.application.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.application.exception.MalformedException;
import com.demo.application.response.PricesResponse;
import com.demo.infraestructure.entity.Prices;

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
