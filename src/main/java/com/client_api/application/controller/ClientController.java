package com.client_api.application.controller;

import com.client_api.domain.dtos.AddressDto;
import com.client_api.domain.dtos.ClientDto;
import com.client_api.domain.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private IClientService service;

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto add(@RequestBody ClientDto clientDto, AddressDto addressDto) throws URISyntaxException, IOException {
       return service.save(clientDto, addressDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<ClientDto> getClients(){
       return service.getClients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ClientDto(@PathVariable Long id, ClientDto clientDto){
        service.updateClient(id, clientDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id){
        service.removeClient(id);
    }
}
