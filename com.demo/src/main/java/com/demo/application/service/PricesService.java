package com.demo.application.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.domain.model.PricesRequest;
import com.demo.domain.model.PricesResponse;
import com.demo.domain.port.PricesRepository;
import com.demo.infrastructure.adapter.PricesRepositoryJPA;
import com.demo.infrastructure.entity.Prices;
import com.demo.infrastructure.rest.exceptions.NoDataFoundException;
import com.demo.infrastructure.rest.exceptions.ParametersException;
import com.demo.infrastructure.rest.mapper.Mapper;

@Service
public class PricesService implements IPricesService{

//	@Autowired
	private final PricesRepository pricesRepository;
	
    public PricesService(@Lazy PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }
	
	public List<Prices> getAll() {

		List<Prices> prices = new ArrayList<Prices>();
		pricesRepository.find().forEach(pricesEt -> prices.add(pricesEt));

		if (ObjectUtils.isEmpty(prices)) {
			throw new NoDataFoundException();
		}
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
