package com.client_api.domain.service;

import com.client_api.domain.dtos.ClientDto;
import com.client_api.domain.service.interfaces.IClientService;
import com.client_api.domain.model.Client;
import com.client_api.feignClient.ICustomerFeignClient;
import com.client_api.feignClient.response.ProductResponse;
import com.client_api.infra.repository.interfaces.IClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService extends BaseService implements IClientService {

    @Autowired
    private IClientRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ICustomerFeignClient feignClient;

    @Override
    public ClientDto save(ClientDto clientDto)  {
        Client client = modelMapper.map(clientDto, Client.class);
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
        ProductResponse productResponse = feignClient.getById(id);
        return modelMapper.map(client, ClientDto.class);
    }
}
