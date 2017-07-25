package com.carlos.cartracking.repo;

import com.carlos.cartracking.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
    Iterable<Car> findAll();
    Car save(Car car);

    @Override
    Car findOne(Integer id);

    void delete(Integer id);
}
