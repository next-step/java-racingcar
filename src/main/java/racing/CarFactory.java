package racing;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createRacingCars(int numberOfCars) {
        return createRacingCars(numberOfCars, () -> Car.DEFAULT_MOVE_POWER_CONDITION);
    }

    public static List<Car> createRacingCars(int numberOfCars, CarMovePowerProvider provider) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < numberOfCars; i++) {

            cars.add(new Car(provider));
        }
        return cars;
    }
}
