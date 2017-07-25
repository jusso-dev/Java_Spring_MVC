package com.carlos.cartracking.controllers;

import com.carlos.cartracking.Services.CarService;
import com.carlos.cartracking.model.Car;
import com.carlos.cartracking.model.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private CarService _carService;

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    public Iterable<Car> ReturnCars() {
        // Iterate through all records in the database
        return this._carService.GetAllCars();
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ResponseEntity<?> SaveCar(@ModelAttribute Car car) {

        // Declare instance of validation class so we can return data to view.
        Validation validation = new Validation();

        try {

            // Take the body of the request and save it to the database as type Car
            this._carService.SaveCar(car);

            // Return 201 created to the user
            return new ResponseEntity<>(validation.success = "Successfully added car object.", HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle error..
            return new ResponseEntity<>(validation.failed = "Failed to submit Car object.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> DeleteCar(@PathVariable Integer id) {
        try {

            // Check we have an id in the request parameters to search on
            if(id == null)
            {
                // This is where you would probably want to tell the user they they passed a null argument
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            // Check the id exists in the database
            else if(this._carService.findOne(id) != null)
            {
                this._carService.DeleteCar(id);
                return new ResponseEntity<>(this._carService.GetAllCars(), HttpStatus.ACCEPTED);
            }

            // At this stage we return a 404, because it doesn't exist...
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> EditCar(@PathVariable Integer id) {
        try {
            // Check we have an id in the request parameters to search on
            if(id == null)
            {
                // This is where you would probably want to tell the user they they passed a null argument
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            // Check the id exists in the database
            else if(this._carService.findOne(id) != null)
            {
                this._carService.DeleteCar(id);
                return new ResponseEntity<>(this._carService.GetAllCars(), HttpStatus.ACCEPTED);
            }

            // At this stage we return a 404, because it doesn't exist...
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
