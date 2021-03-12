package carRacing.domain;

import carRacing.dto.UserInput;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public List<Car> initCars(UserInput userInput){
        List<Car> cars = new ArrayList<>();
        for(int carCount = 0;carCount<userInput.getNumberOfCars();carCount++){
            cars.add(new Car());
        }
        return cars;
    }

}
