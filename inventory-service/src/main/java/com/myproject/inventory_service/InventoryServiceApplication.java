package com.myproject.inventory_service;

import com.myproject.inventory_service.entity.Inventory;
import com.myproject.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);

	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("IPONE_13");
			inventory.setQuantity(100);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("IPONERed_13");
			inventory2.setQuantity(0);
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
		};
	}
}
