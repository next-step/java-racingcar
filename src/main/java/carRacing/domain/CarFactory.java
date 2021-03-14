package carRacing.domain;

import carRacing.dto.UserInput;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public List<Car> initCars(UserInput userInput) {
        List<Car> cars = new ArrayList<>();
        List<String> nameOfCars = userInput.getParsedNameOfCars();
        nameOfCars.forEach(name -> cars.add(new Car(name)));
        return cars;
    }

}
