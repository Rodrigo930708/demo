package com.demo.domain.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.application.exception.NoDataFoundException;
import com.demo.application.exception.ParametersException;
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
		this.validateParameters(request);
		Date fecha = Mapper.convertStringDate(request.getDate());
		
		Optional<Prices> prices = pricesRepository.findByDateProductAndGroup(request.getProductId(), request.getGroup(),fecha).stream()
					.min(Comparator.comparing(Prices::getPriority));
		
		   if (ObjectUtils.isEmpty(prices)) {
	            throw new NoDataFoundException();
	        }
		   
		return Mapper.convertResponse(prices.get());
	}
	
	private void validateParameters(PricesRequest request) {
		if(ObjectUtils.isEmpty(request) || ObjectUtils.isEmpty(request.getProductId())
				|| ObjectUtils.isEmpty(request.getDate()) || ObjectUtils.isEmpty(request.getGroup())) {
            throw new ParametersException();
		}
	}
}
