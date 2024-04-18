package com.client_api.application.controller;

import com.client_api.domain.dtos.CustomerDto;
import com.client_api.domain.service.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto add(@RequestBody CustomerDto customerDto)  {
       return service.save(customerDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<CustomerDto> getClients(){
       return service.getClients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ClientDto(@PathVariable Long id, CustomerDto customerDto){
        service.updateClient(id, customerDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id){
        service.removeClient(id);
    }
}
