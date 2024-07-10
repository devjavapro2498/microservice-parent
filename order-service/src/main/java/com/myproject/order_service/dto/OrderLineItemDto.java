package com.myproject.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemDto {
    private  Long id;
    private  String skuCode;
    private BigInteger price;
    private Integer quantity;
}
