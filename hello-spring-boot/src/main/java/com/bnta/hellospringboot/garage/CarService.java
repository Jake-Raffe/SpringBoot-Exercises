package com.bnta.hellospringboot.garage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarDAO carDAO;

    public CarService(@Qualifier("postgres") CarDAO carDAO){
        this.carDAO = carDAO;
    }

    public void registerNewCar(Car car){
        if(car.getPrice() <= 0){
            throw new IllegalStateException("Price can not be 0 or less");
        }
        int result = carDAO.insertCar(car);
        if (result != 1){
            throw new IllegalStateException("Could not save car");
        }
    }

    public Car findCarById(Integer id){
        return carDAO.selectCarById(id);
    }

    public List<Car> findAllCars(){
        return carDAO.selectAllCars();
    }

    public void deleteCarById(Integer id){
        // add null for wrong input
        // add exception for not found
        Car delCar = carDAO.selectCarById(id);
        int result = carDAO.deleteCar(delCar);
        if (result != 1){
            throw new IllegalStateException("Could not delete car");
        }
    }

    public void updateCar(Integer id, Car update){
        int result = carDAO.updateCar(id, update);
        if (result != 1){
            throw new IllegalStateException("Could not update car");
        }
    }

}
