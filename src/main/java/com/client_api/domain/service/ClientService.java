package com.client_api.domain.service;

import com.client_api.domain.dtos.AddressDto;
import com.client_api.domain.dtos.ClientDto;
import com.client_api.domain.interfaces.IClientService;
import com.client_api.domain.model.Address;
import com.client_api.domain.model.Client;
import com.client_api.infra.repository.interfaces.IClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ClientService extends BaseService implements IClientService {

    @Autowired
    private IClientRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientDto save(ClientDto clientDto, AddressDto addressDto)  {
        Client client = modelMapper.map(clientDto, Client.class);

        Address address = null;
        if(addressDto != null){
            address = modelMapper.map(addressDto, Address.class);
        }

        if(address != null){
            client.setAddress(address);
        }

        Client newClient = repository.save(client);
        return modelMapper.map(newClient, ClientDto.class);
    }

    @Override
    public List<ClientDto> getClients() {
        var clients = repository.findAll();
        return mapList(clients, ClientDto.class);
    }

    @Override
    public void removeClient(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateClient(Long id, ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        client.setId(id);
        repository.save(client);
    }

    @Override
    public ClientDto getById(Long id) {
        Client client = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Categoria com ID " + id + " não encontrada."));
        return modelMapper.map(client, ClientDto.class);
    }
}
