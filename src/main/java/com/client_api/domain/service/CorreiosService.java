package com.client_api.domain.service;

import com.client_api.application.response.CepInformationResponse;
import com.client_api.domain.service.interfaces.ICorreiosService;
import com.client_api.infra.repository.interfaces.ICorreiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CorreiosService implements ICorreiosService {

    @Autowired
    private ICorreiosRepository repository;
    @Override
    public CepInformationResponse getCep(String cep) throws IOException {
       return repository.getCep(cep);
    }
}
