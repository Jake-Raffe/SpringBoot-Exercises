package com.bnta.hellospringboot.garage;

import java.util.List;

public interface CarDAO {
    int insertCar(Car car);
    int deleteCar(Car car);
    int updateCar(Integer id, Car update);
    List<Car> selectAllCars();
    Car selectCarById(Integer id);
}
