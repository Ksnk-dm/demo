package com.example.demo.controller;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PayController {
    @Autowired
    private CityService cityService;
    private final String sharedKey = "ffff";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse("0000", 1);
    }

    @PostMapping("/payss")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody City city) {
        final BaseResponse response;
        if (sharedKey.equalsIgnoreCase(key)) {
            Long userId = city.getId();
            String itemId = city.getName();
            double discount = city.getPopulation();
            cityService.insertCity(new City(itemId, (int) discount));
            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }
}