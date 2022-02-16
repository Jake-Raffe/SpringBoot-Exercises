package com.bnta.hellospringboot.garage;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car){
        carService.registerNewCar(car);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable("id") Integer id){
        carService.deleteCarById(id);
    }

    @GetMapping("/cars/{id}")
    public Car findCarById(@PathVariable("id") Integer id){
        return carService.findCarById(id);
    }

    @GetMapping("/cars")
    public List<Car> findAllCars(){
        return carService.findAllCars();
    }

    @PutMapping("/cars/{id}")
    public void updateCarById(@RequestBody Car car, @PathVariable("id") Integer id){
        carService.updateCar(id, car);
    }
}
