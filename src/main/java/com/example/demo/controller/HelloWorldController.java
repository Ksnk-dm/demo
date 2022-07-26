package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
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
        return "login";
    }
}
