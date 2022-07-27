package com.example.demo.controller;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public List<City> getAll() {
        return cityService.findAll();
    }


    @GetMapping("/addcity")
    public String add() {
        cityService.insertCity(new City("Kyiv", 500000));
        return "add";
    }

    @GetMapping("/")
    public String hello() {
        return "test";
    }
}
