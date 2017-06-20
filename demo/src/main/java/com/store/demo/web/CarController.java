package com.store.demo.web;

import com.store.demo.domain.Buyer;
import com.store.demo.domain.Car;
import com.store.demo.service.CarService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alavi on 18-06-17.
 */
@RestController
@RequestMapping("/cars")
@Api(value="onlinestore", description="Register of cars")

public class CarController {

@Autowired
private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars()
    {
        return  carService.getAllCars();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody CarController.CarRequestDTO carRequestDTO)
    {
        carService.addCar(carRequestDTO);
    }


    @RequestMapping(value = "/{carId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteCar(@PathVariable long carId){
        carService.deleteCarId(carId);
        return  new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/{carId}",method = RequestMethod.PUT)
    public ResponseEntity updateCar(@PathVariable long carId,@RequestBody CarController.CarRequestDTO carRequestDTO){
        carService.updateCar(carId,carRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }


    public static class   CarRequestDTO {
        private String brand;
        private  String year;
        private  String model;
        private  String color;
        private String  image;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

}
