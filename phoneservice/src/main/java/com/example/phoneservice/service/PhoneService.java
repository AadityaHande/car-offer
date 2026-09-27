package com.example.phoneservice.service;

import com.example.phoneservice.entity.Phone;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    public Phone getPhoneByCarPrice(double carPrice) {

        if (carPrice < 2000000) {
            return new Phone(1, "iPhone 16", "Apple", "Black", 80000, 2024);
        }

        if (carPrice < 3000000) {
            return new Phone(2, "iPhone 17 Pro Max", "Apple", "Titanium", 150000, 2025);
        }

        if (carPrice < 4000000) {
            return new Phone(3, "iPhone 18 Pro Max", "Apple", "Black", 180000, 2026);
        }

        return null;
    }
}
