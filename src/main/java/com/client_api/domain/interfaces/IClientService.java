package com.client_api.domain.interfaces;

import com.client_api.domain.dtos.AddressDto;
import com.client_api.domain.dtos.ClientDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface IClientService {
    ClientDto save(ClientDto clientDto, AddressDto addressDto);
    List<ClientDto> getClients();
    void removeClient(Long id);
    void updateClient(Long id, ClientDto clientDto);
    ClientDto getById(Long id);
}
