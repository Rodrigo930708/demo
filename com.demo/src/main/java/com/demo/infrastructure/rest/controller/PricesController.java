package com.demo.infrastructure.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.application.service.PricesService;
import com.demo.domain.model.PricesRequest;
import com.demo.domain.model.PricesResponse;
import com.demo.infrastructure.entity.Prices;

@RestController
@RequestMapping("/prices")
public class PricesController {

//	@Autowired
	private PricesService pricesService;
	

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }
	
	@GetMapping("/read")
	public List<Prices> getAllPrices() {
		return pricesService.getAll();
	}
	
	@GetMapping("/read-by-parameters")
	public PricesResponse findByDateProductAndGroup(@RequestBody PricesRequest request) {
		return pricesService.findByDateProductAndGroup(request);
	}
}

