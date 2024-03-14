package com.client_api.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
//    private String cep;
//    private String logradouro;
//    private String bairro;
//    private String localidade;
//    private String uf;
    @OneToOne
    @JoinColumn(name = "client_id")
    @JsonManagedReference
    private Address address;
}
