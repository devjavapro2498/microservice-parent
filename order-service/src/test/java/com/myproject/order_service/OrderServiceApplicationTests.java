package com.myproject.order_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.order_service.dto.OrderLineItemDto;
import com.myproject.order_service.dto.OrderRequest;
import com.myproject.order_service.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
/*@Testcontainers
@AutoConfigureMockMvc*/
class OrderServiceApplicationTests {
/*
@Container
static MySQLContainer mySQLContainer= new MySQLContainer("mysql:8.4");


	@Autowired
	private MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private OrderRepository orderRepository;
	@DynamicPropertySource*/
/*	static  void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.datasource.url" , mySQLContainer::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username" , mySQLContainer::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password" , mySQLContainer::getPassword);
	}
	@Test
	void shouldCreateOrder() throws Exception  {
		OrderRequest orderRequest= new OrderRequest();
		orderRequest.setOrderLineItemListDto(getOrderList());
		String ProductRequestInString= objectMapper.writeValueAsString(orderRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/order").contentType(MediaType.APPLICATION_JSON)
				.content(ProductRequestInString)).andExpect(status().isCreated());
	//	Assertions.assertEquals(1, orderRepository.findAll().size());

	}

	private List<OrderLineItemDto> getOrderList() {
		List<OrderLineItemDto> orderLineItemDtoList = new ArrayList<>();
		orderLineItemDtoList.add(getOrderLineItemDto());
		return orderLineItemDtoList;
	}

	private OrderLineItemDto getOrderLineItemDto() {
		return OrderLineItemDto.builder()
				.skuCode("AZ-ES-TU")
				.quantity(1)
				.prices(BigInteger.valueOf(1234))
				.build();
	}*/
/*	@Test
	void  getProductDetails() throws  Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/order").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Assertions.assertEquals(1,orderRepository.findAll().size());



	}*/

}

