package com.demo.application.service;

import java.util.List;

import com.demo.domain.model.PricesRequest;
import com.demo.domain.model.PricesResponse;
import com.demo.infrastructure.entity.Prices;

public interface IPricesService {

	public List<Prices> getAll();
	public PricesResponse findByDateProductAndGroup(PricesRequest request);
}
