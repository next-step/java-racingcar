package racing;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createRacingCars(int numberOfCars) {
        return createRacingCars(numberOfCars, Car.randomMoveConditionProvider);
    }

    public static List<Car> createRacingCars(int numberOfCars, CarMoveConditionProvider provider) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(provider));
        }
        return cars;
    }
}
