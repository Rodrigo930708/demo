package com.demo.infrastructure.adapter;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.demo.domain.port.PricesRepository;
import com.demo.infrastructure.entity.Prices;

@Repository
public class PricesRepositoryJPAImpl implements PricesRepository{
	
//	@Autowired
	private PricesRepositoryJPA pricesRepositoryJPA;
	
	 public PricesRepositoryJPAImpl(@Lazy PricesRepositoryJPA pricesRepositoryJPA) {
	        this.pricesRepositoryJPA = pricesRepositoryJPA;
	    }

	@Override
	public List<Prices> findByDateProductAndGroup(Integer productId, Integer group, Date fecha) {
		return pricesRepositoryJPA.findByDateProductAndGroup(productId, group, fecha);
	}

	@Override
	public List<Prices> find() {
		return pricesRepositoryJPA.findAll();
	}

}
