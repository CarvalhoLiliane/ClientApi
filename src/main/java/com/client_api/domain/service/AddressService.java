package com.client_api.domain.service;

import com.client_api.domain.dtos.AddressDto;
import com.client_api.domain.service.interfaces.IAddressService;
import com.client_api.domain.model.Address;
import com.client_api.infra.repository.interfaces.IAddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService implements IAddressService {

    @Autowired
    private IAddressRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressDto save(AddressDto addressDto)  {
        Address address = modelMapper.map(addressDto, Address.class);
        Address newAddress = repository.save(address);
        return modelMapper.map(newAddress, AddressDto.class);
    }

    @Override
    public void removeAddress(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateAddress(Long id, AddressDto addressDto) {
        var address = modelMapper.map(addressDto, Address.class);
        address.setId(id);
        repository.save(address);
    }

}
