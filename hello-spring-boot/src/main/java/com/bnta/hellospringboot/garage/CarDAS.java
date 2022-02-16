package com.bnta.hellospringboot.garage;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgres")
public class CarDAS implements CarDAO {


    private JdbcTemplate jdbcTemplate;

    public CarDAS(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCar(Car car) {
        String insertSql = """
                INSERT INTO cars(brand, price)
                VALUES(?, ?)
                """;
        int result = jdbcTemplate.update(insertSql, car.getBrand(), car.getPrice());
        return result;
    }

    @Override
    public Car selectCarById(Integer id) {
        return jdbcTemplate.queryForObject("""
                SELECT * FROM cars WHERE id = ?
                """, new Object[]{id}, (rs, rowNum) -> new Car(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getInt("price"))
        );
    }

    @Override
    public List<Car> selectAllCars() {
        return jdbcTemplate.query("""
                SELECT * FROM cars
                """,
                (rs, rowNum) ->
                    new Car(
                            rs.getInt("id"),
                            rs.getString("brand"),
                            rs.getInt("price"))
                    );
    }

    @Override
    public int deleteCar(Car car) {
        return jdbcTemplate.update(
                """
                        DELETE FROM cars WHERE id = ?
                        """, car.getId());
    }

    @Override
    public int updateCar(Integer id, Car update) {
        return jdbcTemplate.update(
                """
                        UPDATE cars SET (brand, price) = (?,?) WHERE id = ?""",
                update.getBrand(), update.getPrice(), id);
    }
}
