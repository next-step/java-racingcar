package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarExecutor {
    private static List<Car> cars;
    private static Random random = new Random();
    private static final int MOVING_STANDARD = 4;

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
        int randomNumber = random.nextInt(10);
        if (randomNumber >= MOVING_STANDARD) {
            car.move();
        }
    }

}
