package com.bnta.hellospringboot.garage;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeCarDataAccessService implements CarDAO {

    private List<Car> cars;

    public FakeCarDataAccessService(){
        this.cars = new ArrayList<>();
    }

    @Override
    public int insertCar(Car car) {
        try {cars.add(car);
        return 1;}
        catch (Exception e){
            return 0;
        }
    }

    @Override
    public int deleteCar(Car car) {
        try {
            cars.remove(car);
            return 1;
        } catch (Exception e){
            return 0;
        }
    }

    @Override
    public List<Car> selectAllCars() {
        return cars;
    }

    @Override
    public Car selectCarById(Integer id) {
        Car output = null;
        for (Car c :
                cars) {
            if (id.equals(c.getId())){
                output = c;
                break;
            }
        }
        return output;
    }

    @Override
    public int updateCar(Integer id, Car update) {
        cars.remove(id-1);
        cars.add(update);
        return 1;
    }
}
