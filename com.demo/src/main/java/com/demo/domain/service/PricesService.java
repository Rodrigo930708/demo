package com.demo.domain.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.application.mapper.Mapper;
import com.demo.application.request.PricesRequest;
import com.demo.application.response.PricesResponse;
import com.demo.domain.repository.PricesRepository;
import com.demo.infraestructure.entity.Prices;

@Service
public class PricesService {

	@Autowired
	private PricesRepository pricesRepository;
	
	public List<Prices> getAll() {
		
		List<Prices> prices = new ArrayList<Prices>();
		pricesRepository.findAll().forEach(pricesEt -> prices.add(pricesEt));

		return prices;
		
	}
	public PricesResponse findByDateProductAndGroup(PricesRequest request) {
		
		Date fecha = Mapper.convertStringDate(request.getFecha());
		
		Prices prices = pricesRepository.findByDateProductAndGroup(request.getProductId(), request.getGroup(),fecha).stream()
					.min(Comparator.comparing(Prices::getPriority)).get();
		
		return Mapper.convertResponse(prices);
		
	}
}
