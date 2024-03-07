package com.client_api.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {
    private Long id;
    private String state;
    private String city;
    private String neighborhood;
    private String road;
    private String ZipCode;
}
