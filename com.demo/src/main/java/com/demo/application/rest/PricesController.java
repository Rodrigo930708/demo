package com.demo.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.service.PricesService;
import com.demo.infraestructure.entity.Prices;

@RestController
public class PricesController {

	@Autowired
	private PricesService pricesService;
	
	@GetMapping("/prices")
	private List<Prices> getAllPrices() {
		return pricesService.getAll();
	}
}
