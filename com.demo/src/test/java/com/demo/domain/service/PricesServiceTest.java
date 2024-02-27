package com.demo.domain.service;

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
public class PricesServiceTest {

	@Autowired
	private PricesService pricesService;

	@Test
	void getAll_Test_Ok() {
		
		List<Prices> prices = pricesService.getAll();
		
		assertNotNull(prices);
		assertEquals(4,prices.size());

	}
	
	@Test
	void findByDateProductAndGroup_Test_Ok() {
		
		PricesRequest pricesRequest = new PricesRequest();
		pricesRequest.setDate("2020-06-14 16:00:00");
		pricesRequest.setGroup(1);
		pricesRequest.setProductId(35455);
		
		PricesResponse prices = pricesService.findByDateProductAndGroup(pricesRequest);
		
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
				
	    assertThrows(NoDataFoundException.class, () -> pricesService.findByDateProductAndGroup(pricesRequest));

	}
	
	@Test
	void findByDateProductAndGroup_Test_ParametersException() {
		
		PricesRequest pricesRequest = new PricesRequest();
		pricesRequest.setDate("2020-06-14 16:00:00");
		pricesRequest.setProductId(35455);
				
	    assertThrows(ParametersException.class, () -> pricesService.findByDateProductAndGroup(pricesRequest));
	}
	
	@Test
	void findByDateProductAndGroup_Test_MalformedException() {
		
		PricesRequest pricesRequest = new PricesRequest();
		pricesRequest.setGroup(2);
		pricesRequest.setDate("2020-06 16:00:00");
		pricesRequest.setProductId(35455);
				
	    assertThrows(MalformedException.class, () -> pricesService.findByDateProductAndGroup(pricesRequest));
	}
}
