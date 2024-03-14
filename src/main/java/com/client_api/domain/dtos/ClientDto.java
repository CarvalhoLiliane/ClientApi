package com.client_api.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto implements Serializable {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private Date dateOfBirt;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
