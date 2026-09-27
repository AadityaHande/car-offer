package com.carwala.backend.client;

import com.carwala.backend.entity.Phone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "phone-service", url = "${phone.service.url}")
public interface PhoneClient {

    @GetMapping("/phones/offer/{carPrice}")
    Phone getPhone(@PathVariable("carPrice") double carPrice);
}
