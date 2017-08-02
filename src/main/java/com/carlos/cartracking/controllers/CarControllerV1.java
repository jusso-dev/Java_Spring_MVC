package com.carlos.cartracking.controllers;

import com.carlos.cartracking.Services.CarService;
import com.carlos.cartracking.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarControllerV1 {

    @Autowired
    private CarService _carService;

    // Request mapping allows us to defind what our end-point will respond to
    // Im this instance we only want to home page to respond to GET requests
    @RequestMapping(value = "/", method = RequestMethod.GET)

    // The following method returns our Model and View
    // We iterate over our car objects in this method as well to pass to the view
    // So we can display them to the end user
    public ModelAndView Index() {

        // Iterate through cars
        Iterable<Car> cars = this._carService.GetAllCars();

        // Create ModelAndView object and pass String to tell it what view to render
        ModelAndView modelAndView = new ModelAndView("Index");

        // Pass our car objects into our Model and View
        // tell it what the name of our attribute is to be used in the view
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }

}
