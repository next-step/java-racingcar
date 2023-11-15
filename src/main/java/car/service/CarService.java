package car.service;

import car.domain.Car;
import car.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarService {

    public static List<Car> generate(String[] names) {
        List<Car> cars = new ArrayList<Car>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private static int randomValue() {
        return RandomUtil.randomNumber();
    }

    public static void repeatMove(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomValue());
        }
    }

}
