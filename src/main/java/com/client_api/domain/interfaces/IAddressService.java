package com.client_api.domain.interfaces;

import com.client_api.domain.dtos.AddressDto;

public interface IAddressService {
    AddressDto save(AddressDto addressDto);
    void removeAddress(Long id);
    void updateAddress(Long id, AddressDto addressDto);
}
