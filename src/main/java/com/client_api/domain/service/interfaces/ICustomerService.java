package com.client_api.domain.service.interfaces;

import com.client_api.domain.dtos.CustomerDto;

import java.util.List;

public interface ICustomerService {
    CustomerDto save(CustomerDto customerDto);
    List<CustomerDto> getClients();
    void removeClient(Long id);
    void updateClient(Long id, CustomerDto customerDto);
    CustomerDto getById(Long id);
}
