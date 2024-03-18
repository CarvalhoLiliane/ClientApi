package com.client_api.feignClient.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer amount;
    private String description;
    private Long category;
}
