package carRacing.controller;

import carRacing.domain.Car;
import carRacing.domain.CarFactory;
import carRacing.domain.View;
import carRacing.dto.UserInput;
import carRacing.service.CarRacingService;

import java.util.List;

public class CarRacingController {

    private View view = new View();
    private CarFactory carFactory = new CarFactory();
    private CarRacingService carRacingService = new CarRacingService();

    public void run() {
        UserInput userInput = view.getUserInput();
        List<Car> cars = carFactory.initCars(userInput);
        carRacingService.run(userInput, cars);
    }
}
