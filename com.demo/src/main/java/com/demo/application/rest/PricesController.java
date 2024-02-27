package com.demo.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.application.request.PricesRequest;
import com.demo.application.response.PricesResponse;
import com.demo.domain.service.PricesService;
import com.demo.infraestructure.entity.Prices;

@RestController
@RequestMapping("/prices")
public class PricesController {

	@Autowired
	private PricesService pricesService;
	
	@GetMapping("/read")
	public List<Prices> getAllPrices() {
		return pricesService.getAll();
	}
	
	@PostMapping("/read-by-parameters")
	public PricesResponse findByDateProductAndGroup(@RequestBody PricesRequest request) {
		return pricesService.findByDateProductAndGroup(request);
	}
}

