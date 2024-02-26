package com.demo.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
