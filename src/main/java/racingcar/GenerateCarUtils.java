package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateCarUtils {
    public static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int carIndex = 0; carIndex < carCount; carIndex++) {
            cars.add(new Car(new Random()));
        }
        return cars;
    }
}
