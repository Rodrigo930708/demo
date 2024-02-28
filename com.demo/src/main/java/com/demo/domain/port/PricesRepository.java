package com.demo.domain.port;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.infrastructure.entity.Prices;

public interface PricesRepository{

	
	List<Prices> findByDateProductAndGroup(Integer productId, Integer group, Date fecha);
	List<Prices> find();

}
