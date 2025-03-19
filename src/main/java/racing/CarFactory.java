package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class CarFactory {

    public static List<Car> createRacingCars(int numberOfCars) {
        return createRacingCars(numberOfCars, Car.randomMoveConditionSupplier);
    }

    public static List<Car> createRacingCars(int numberOfCars, BooleanSupplier moveConditionSupplier) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(moveConditionSupplier));
        }
        return cars;
    }
}
