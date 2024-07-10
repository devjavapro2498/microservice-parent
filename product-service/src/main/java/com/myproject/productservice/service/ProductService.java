package com.myproject.productservice.service;

import com.myproject.productservice.dto.ProductRequest;
import com.myproject.productservice.dto.ProductResponse;
import com.myproject.productservice.entity.Product;
import com.myproject.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private  final ProductRepository productRepository;



    public  void createProduct(@RequestBody ProductRequest productRequest){
        Product product= Product.builder().name(productRequest.getName()
                ).description(productRequest.getDescription())
                .prices(productRequest.getPrices()).build();
        productRepository.save(product);
        log.info("Product {} is saved",product.getId());


    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products= productRepository.findAll();
        return products.stream().map(this::mapAllTheProductWithDto).toList();
    }
    private  ProductResponse mapAllTheProductWithDto(Product product){
        return  ProductResponse.builder().
                id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .prices(product.getPrices()).build();


    }

}
