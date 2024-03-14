package com.client_api.domain.service;


import com.client_api.domain.dtos.AddressDto;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CepService {
 public AddressDto getAddress(String cep) throws IOException {
     AddressDto addressDto = null;
     HttpGet request = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/");
     try(CloseableHttpClient httpClient = HttpClientBuilder.create().build();
         CloseableHttpResponse response = httpClient.execute(request)){

         HttpEntity entity = response.getEntity();
         if(entity != null){
             String result = EntityUtils.toString(entity);

             Gson gson = new Gson();
             addressDto = gson.fromJson(result, AddressDto.class);
         }

     }
     return addressDto;
 }

//    public static void main(String[] args) throws IOException {
//     CepService cepService = new CepService();
//
//        String endereco = String.valueOf(cepService.getAddress("24342750"));
//        System.out.println(endereco);
//    }

}
