package com.client_api.domain.service.interfaces;

import com.client_api.domain.dtos.AddressDto;
import com.client_api.domain.model.Address;

public interface IAddressService {
    AddressDto save(AddressDto addressDto) ;
    void removeAddress(Long id);
    void updateAddress(Long id, AddressDto addressDto);
}
