package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<Car> cars = new ArrayList<>();

    public static void addCar(Car car) {
        cars.add(car);
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static void clear() {
        cars.clear();
    }
}
