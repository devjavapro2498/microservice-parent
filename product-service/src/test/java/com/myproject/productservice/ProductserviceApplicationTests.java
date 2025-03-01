package com.myproject.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.productservice.dto.ProductRequest;
import com.myproject.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductserviceApplicationTests {
    @Container
	static MongoDBContainer mongoDBContainer= new MongoDBContainer("mongo:4.0.10");
	@Autowired
private MockMvc mockMvc;
	@Autowired
   ObjectMapper objectMapper;
	@Autowired
	private ProductRepository productRepository;
	@DynamicPropertySource
	static  void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri" , mongoDBContainer::getReplicaSetUrl);
	}
	@Test
	void shouldCreateProduct() throws Exception  {
 ProductRequest productRequest=getProductRequest();
String ProductRequestInString= objectMapper.writeValueAsString(productRequest);
            mockMvc.perform(MockMvcRequestBuilders.post("/api/product").contentType(MediaType.APPLICATION_JSON)
                    .content(ProductRequestInString)).andExpect(status().isCreated());
			Assertions.assertEquals(1, productRepository.findAll().size());

    }

	private ProductRequest getProductRequest() {
		return  ProductRequest.builder()
				.name("Iphone")
				.description("Mobile")
				.prices(BigDecimal.valueOf(1234))
				.build();
	}
	@Test
	void  getProductDetails() throws  Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Assertions.assertEquals(1,productRepository.findAll().size());



	}

}
