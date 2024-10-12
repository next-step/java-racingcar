package racingcar.util;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;


public class CarFactory {
    private static final List<Car> cars = new ArrayList<>();


    public static List<Car> createCars(int competitors) {
        for (int i = 0; i < competitors; i++) {
            cars.add(new Car(new RandomNumberGenerator()));
        }
        return cars;
    }
}
