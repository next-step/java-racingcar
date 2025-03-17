package racingcar;

import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<Car> cars;

    public Cars(int carCounts) {
        cars = new ArrayList<>();
        for (int index = 0; index < carCounts; index++) {
            Car car = new Car();
            cars.add(car);
        }
    }

    public static void move(List<Car> cars) {
        for(Car car: cars) {
            int randomNumber = RandomNumberGenerator.getRandomNumber();
            car.move(randomNumber);
        }
    }
}
