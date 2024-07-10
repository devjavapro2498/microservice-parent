package com.myproject.order_service.service;

import com.myproject.order_service.dto.InventoryResponse;
import com.myproject.order_service.dto.OrderLineItemDto;
import com.myproject.order_service.dto.OrderRequest;
import com.myproject.order_service.entity.Order;
import com.myproject.order_service.entity.OrderLineItem;
import com.myproject.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private  final OrderRepository orderRepository;
    private  final WebClient webClient;
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> mapDtoToEntity = orderRequest.getOrderLineItemsDtoList().stream()
                .map(this::mapToDto).toList();
        order.setOrderLineItemList(mapDtoToEntity);
        List<String> skuCodeList = order.getOrderLineItemList().stream()
                .map(OrderLineItem::getSkuCode).toList();


        InventoryResponse[] inventoryResponseArray = webClient.get().uri("http://localhost:8080/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodeList).build())
                .retrieve().bodyToMono(InventoryResponse[].class)
                .block();
        boolean allProductIsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
        if(allProductIsInStock){
            orderRepository.save(order);
        }else {
            throw  new IllegalArgumentException("Product isn't in Stock.Please Try Again Later");
        }


    }

    private OrderLineItem mapToDto(OrderLineItemDto orderLineItemDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setId(orderLineItemDto.getId());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());
        orderLineItem.setPrice(orderLineItemDto.getPrice());
        orderLineItem.setSkuCode(orderLineItemDto.getSkuCode());
        return orderLineItem;
    }
}
