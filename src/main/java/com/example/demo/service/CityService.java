package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public void insertCity(City city){
        cityRepository.save(city);
    }

    @Transactional
    public List<City> findAll() {
        return cityRepository.findAll();
    }

}
