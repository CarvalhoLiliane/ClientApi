package com.client_api.feignClient;

import com.client_api.feignClient.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "products", url = "localhost:9000", path = "/products")
public interface ICustomerFeignClient {

    @GetMapping("/{id}")
    ProductResponse getById(@PathVariable Long id);

}
