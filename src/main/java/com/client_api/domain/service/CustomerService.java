package com.client_api.domain.service;

import com.client_api.domain.dtos.CustomerDto;
import com.client_api.domain.model.Customer;
import com.client_api.domain.service.interfaces.ICustomerService;
import com.client_api.feignClient.ICustomerFeignClient;
import com.client_api.feignClient.response.ProductResponse;
import com.client_api.infra.repository.interfaces.ICustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends BaseService implements ICustomerService {

    @Autowired
    private ICustomerRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ICustomerFeignClient feignClient;

    @Override
    public CustomerDto save(CustomerDto customerDto)  {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer newCustomer = repository.save(customer);
        return modelMapper.map(newCustomer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getClients() {
        var clients = repository.findAll();
        return mapList(clients, CustomerDto.class);
    }

    @Override
    public void removeClient(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateClient(Long id, CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer.setId(id);
        repository.save(customer);
    }

    @Override
    public CustomerDto getById(Long id) {
        Customer customer = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Categoria com ID " + id + " não encontrada."));
        //ProductResponse productResponse = feignClient.getById(id);
        return modelMapper.map(customer, CustomerDto.class);
    }
}
