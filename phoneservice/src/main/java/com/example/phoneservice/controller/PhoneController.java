package com.example.phoneservice.controller;

import com.example.phoneservice.entity.Phone;
import com.example.phoneservice.service.PhoneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public String home() {
        return "Phone Service is running";
    }

    // This endpoint is called by Car Service using Feign Client
    @GetMapping("/offer/{carPrice}")
    public Phone getPhoneOffer(@PathVariable double carPrice) {
        return phoneService.getPhoneByCarPrice(carPrice);
    }
}
