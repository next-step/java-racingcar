package racingGame.business;

import java.util.ArrayList;
import java.util.List;
import racingGame.model.Car;
import racingGame.model.NonNegativeReadyCars;

public class CarFactory {
    
    public static List<Car> createCars(NonNegativeReadyCars names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.getNames()) {
            cars.add(new Car(name));
        }
        return cars;
    }

}
