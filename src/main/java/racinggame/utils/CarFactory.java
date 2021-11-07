package racinggame.utils;

import racinggame.Car;
import racinggame.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static RacingCars createRacingCars(int numberOfCars) {
        return new RacingCars(createCars(numberOfCars));
    }

    private static List<Car> createCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }


}
