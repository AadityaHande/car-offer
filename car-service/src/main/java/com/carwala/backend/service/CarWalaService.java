package com.carwala.backend.service;

import com.carwala.backend.client.PhoneClient;
import com.carwala.backend.entity.Car;
import com.carwala.backend.entity.Phone;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarWalaService {

    private final List<Car> cars = new ArrayList<>();
    private final PhoneClient phoneClient;

    public CarWalaService(PhoneClient phoneClient) {
        this.phoneClient = phoneClient;
    }

    public Car addCar(Car car) {
        cars.add(car);
        return car;
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car getCarById(long id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public Car updateCar(long id, Car updatedCar) {
        Car car = getCarById(id);

        if (car == null) {
            return null;
        }

        updatedCar.setId(id);
        cars.remove(car);
        cars.add(updatedCar);

        return updatedCar;
    }

    public boolean deleteCar(long id) {
        Car car = getCarById(id);

        if (car == null) {
            return false;
        }

        cars.remove(car);
        return true;
    }

    public Phone getPhoneOffer(long carId) {
        Car car = getCarById(carId);

        if (car == null) {
            return null;
        }

        return phoneClient.getPhone(car.getPrice());
    }
}
