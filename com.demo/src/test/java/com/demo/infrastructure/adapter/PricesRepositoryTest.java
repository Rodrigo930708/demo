package com.demo.infrastructure.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.infrastructure.adapter.PricesRepositoryJPA;
import com.demo.infrastructure.entity.Prices;
import com.demo.infrastructure.rest.mapper.Mapper;

@SpringBootTest
public class PricesRepositoryTest {
	
	@Autowired
	private PricesRepositoryJPA pricesRepository;

	@Test
	void findByDateProductAndGroup_Test_Ok() {
		
		Date se = Mapper.convertStringDate("2020-06-14 16:00:00");
		
		List<Prices> prices = pricesRepository.findByDateProductAndGroup(35455, 1, se);
		
		assertNotNull(prices);
		assertEquals(2,prices.size());

	}
	
	@Test
	void findAll_Test_Ok() {
				
		List<Prices> prices = pricesRepository.findAll();
		
		assertNotNull(prices);
		assertEquals(4,prices.size());

	}
}
