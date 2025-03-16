package racingcar;

import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarExecutor {
    private static List<Car> cars;

    private CarExecutor() {

    }

    public static List<Car> initializeCars(int cartCounts) {
        cars = new ArrayList<>();
        for (int index = 0; index < cartCounts; index++) {
            Car car = new Car();
            cars.add(car);
        }
        return cars;
    }

    public static void move(Car car) {
        int randomNumber = RandomNumberGenerator.getRandomNumber();
        car.move(randomNumber);
    }
}
