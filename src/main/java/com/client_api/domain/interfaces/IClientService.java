package com.client_api.domain.interfaces;

import com.client_api.domain.dtos.ClientDto;

import java.util.List;

public interface IClientService {
    ClientDto save(ClientDto clientDto);
    List<ClientDto> getClients();
    void removeClient(Long id);
    void updateClient(Long id, ClientDto clientDto);
    ClientDto getById(Long id);
}
