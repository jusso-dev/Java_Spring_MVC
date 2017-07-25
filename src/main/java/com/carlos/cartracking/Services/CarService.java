package com.carlos.cartracking.Services;

import com.carlos.cartracking.model.Car;
import com.carlos.cartracking.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    // Bringing in our repository to use it in our service
    @Autowired
    private CarRepository _carRepo;

    // Defining a constructor for dependency injection
    public CarService(CarRepository carRepo) {
        this._carRepo = carRepo;
    }

    public Iterable<Car> GetAllCars(){
        return this._carRepo.findAll();
    }

    public void SaveCar(Car car) {
        this._carRepo.save(car);
    }

    public Car findOne(Integer id) {
       return this._carRepo.findOne(id);
    }

    public void DeleteCar(Integer id) {
       this._carRepo.delete(id);
    }
}
