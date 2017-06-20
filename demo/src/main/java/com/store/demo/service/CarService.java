package com.store.demo.service;

import com.store.demo.domain.Buyer;
import com.store.demo.domain.Car;
import com.store.demo.repository.CarRepository;
import com.store.demo.web.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alavi on 18-06-17.
 */
@Service
public class CarService {
    @Autowired
    private  CarRepository carRepository;
    public List<Car> getAllCars() {
        return  carRepository.findAll();
    }

    public void addCar(CarController.CarRequestDTO carRequestDTO) {
        Car newcar= new Car();
        newcar.setBrand(carRequestDTO.getBrand());
        newcar.setColor(carRequestDTO.getColor());
        newcar.setModel(carRequestDTO.getModel());
        newcar.setImage(carRequestDTO.getImage());
        newcar.setYear(carRequestDTO.getYear());
        carRepository.save(newcar);
    }

    public void deleteCarId(long carId) {

        carRepository.delete(carId);
    }

    public void updateCar(long carId, CarController.CarRequestDTO carRequestDTO) {
        Car actualizar = carRepository.findOne(carId);
        actualizar.setBrand(carRequestDTO.getBrand());
        actualizar.setImage(carRequestDTO.getImage());
        actualizar.setColor(carRequestDTO.getColor());
        actualizar.setModel(carRequestDTO.getModel());
        actualizar.setYear(carRequestDTO.getYear());

        carRepository.save(actualizar);
    }
}
