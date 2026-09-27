package com.carwala.backend.controller;

import com.carwala.backend.entity.Car;
import com.carwala.backend.entity.Phone;
import com.carwala.backend.exception.CarNotFoundException;
import com.carwala.backend.service.CarWalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarWalaService carWalaService;

    public CarController(CarWalaService carWalaService) {
        this.carWalaService = carWalaService;
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carWalaService.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carWalaService.getAllCars();
    }

    
    // car not found exception 
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id) {
        Car car = carWalaService.getCarById(id);

        if (car == null) {
            throw new CarNotFoundException("Car with ID " + id + " not found");
        }

        return ResponseEntity.ok(car);
    }

    // Select a car and check which phone is available with its offer
    @GetMapping("/{id}/offer")
    public ResponseEntity<Phone> getPhoneOffer(@PathVariable long id) {
        Phone phone = carWalaService.getPhoneOffer(id);

        if (phone == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(phone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(
            @PathVariable long id,
            @RequestBody Car car) {

        Car updatedCar = carWalaService.updateCar(id, car);

        if (updatedCar == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable long id) {
        if (!carWalaService.deleteCar(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
        
}
