package com.demo.application.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.application.exception.MalformedException;
import com.demo.application.exception.NoDataFoundException;
import com.demo.application.exception.ParametersException;
import com.demo.application.request.PricesRequest;
import com.demo.application.response.PricesResponse;
import com.demo.infraestructure.entity.Prices;

@SpringBootTest
public class PricesControllerTest {

	@Autowired
	private PricesController pricesController;

	@Test
	void getAllPrices_Test_Ok() {
		
		List<Prices> prices = pricesController.getAllPrices();
		
		assertNotNull(prices);
		assertEquals(4,prices.size());

	}
	
	@Test
	void findByDateProductAndGroup_Test_Ok() {
		
		PricesRequest pricesRequest = new PricesRequest();
		pricesRequest.setDate("2020-06-14 16:00:00");
		pricesRequest.setGroup(1);
		pricesRequest.setProductId(35455);
		
		PricesResponse prices = pricesController.findByDateProductAndGroup(pricesRequest);
		
		assertNotNull(prices);
		assertEquals(35455, prices.getProductId());
		assertEquals(1, prices.getGroup());

	}
	
	@Test
	void findByDateProductAndGroup_Test_NoDataFoundException() {
		
		PricesRequest pricesRequest = new PricesRequest();
		pricesRequest.setDate("2020-06-14 16:00:00");
		pricesRequest.setGroup(2);
		pricesRequest.setProductId(35455);
				
	    assertThrows(NoDataFoundException.class, () -> pricesController.findByDateProductAndGroup(pricesRequest));

	}
	
	@Test
	void findByDateProductAndGroup_Test_ParametersException() {
		
		PricesRequest pricesRequest = new PricesRequest();
		pricesRequest.setDate("2020-06-14 16:00:00");
		pricesRequest.setProductId(35455);
				
	    assertThrows(ParametersException.class, () -> pricesController.findByDateProductAndGroup(pricesRequest));
	}
	
	@Test
	void findByDateProductAndGroup_Test_MalformedException() {
		
		PricesRequest pricesRequest = new PricesRequest();
		pricesRequest.setGroup(2);
		pricesRequest.setDate("2020-06 16:00:00");
		pricesRequest.setProductId(35455);
				
	    assertThrows(MalformedException.class, () -> pricesController.findByDateProductAndGroup(pricesRequest));
	}
}
