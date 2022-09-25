package racinggame.core;

import java.util.ArrayList;
import java.util.List;

public class GameInitializer {

    public static List<Car> initCars(int numOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numOfCar; i++) {
            cars.add(new Car());
        }

        return cars;
    }

}
