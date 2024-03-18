package com.client_api.infra.repository.interfaces;

import com.client_api.application.response.CepInformationResponse;

import java.io.IOException;


public interface ICorreiosRepository {
    CepInformationResponse getCep(String cep) throws IOException;
}
