package com.client_api.application.controller;

import com.client_api.domain.dtos.AddressDto;
import com.client_api.application.response.CepInformationResponse;
import com.client_api.domain.service.interfaces.IAddressService;
import com.client_api.domain.service.interfaces.ICorreiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private IAddressService service;

    @Autowired
    private ICorreiosService correiosService;

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDto add(@RequestBody AddressDto addressDto)  {
        return service.save(addressDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable Long id){
        service.removeAddress(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, AddressDto addressDto){
         service.updateAddress(id, addressDto);
    }

    @GetMapping("/servico-cep")
    public CepInformationResponse getCepInformation(@RequestParam String cep) throws IOException {
      return correiosService.getCep(cep);
    }
}
