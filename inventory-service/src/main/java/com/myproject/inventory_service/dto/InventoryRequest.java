package com.myproject.inventory_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InventoryRequest {
    private  Long id;
    private  String skuCode;
    private Integer quantity;
}
