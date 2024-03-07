package com.client_api.application.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean
    public ModelMapper modelMapper(){
        var mapper = new ModelMapper();
        mapper.getConfiguration().setFieldMatchingEnabled(true);
        return mapper;
    }
}
