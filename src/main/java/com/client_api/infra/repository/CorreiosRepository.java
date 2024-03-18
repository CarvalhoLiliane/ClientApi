package com.client_api.infra.repository;

import com.client_api.application.response.CepInformationResponse;
import com.client_api.infra.repository.interfaces.ICorreiosRepository;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class CorreiosRepository implements ICorreiosRepository {
    @Override
    public CepInformationResponse getCep(String cep) throws IOException {
        CepInformationResponse cepInformationDto = null;
        HttpGet request = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/");
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            CloseableHttpResponse response = httpClient.execute(request)){

            HttpEntity entity = response.getEntity();
            if(entity != null){
                String result = EntityUtils.toString(entity);

                Gson gson = new Gson();
                cepInformationDto = gson.fromJson(result, CepInformationResponse.class);
            }

        }
        return cepInformationDto;
    }
}
