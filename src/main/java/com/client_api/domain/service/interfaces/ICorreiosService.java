package com.client_api.domain.service.interfaces;

import com.client_api.application.response.CepInformationResponse;

import java.io.IOException;


public interface ICorreiosService {
    CepInformationResponse getCep(String cep) throws IOException;
}
