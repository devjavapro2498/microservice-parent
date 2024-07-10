package com.myproject.inventory_service.controller;

import com.myproject.inventory_service.dto.InventoryResponse;
import com.myproject.inventory_service.service.InventoryServce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
   private final InventoryServce inventoryServce;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
return inventoryServce.isInStock(skuCode);

}

}
