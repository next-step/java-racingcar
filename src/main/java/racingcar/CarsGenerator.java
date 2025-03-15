package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarsGenerator {

    public List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int carIndex = 0; carIndex < carCount; carIndex++) {
            cars.add(new Car());
        }
        return cars;
    }
}
