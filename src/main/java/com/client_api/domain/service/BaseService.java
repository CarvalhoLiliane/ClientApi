package com.client_api.domain.service;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BaseService {
    <S, T>List<T> mapList(List<S> source, Class<T> targetClass){
        ModelMapper modelMapper = new ModelMapper();
        return source.stream().map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
