package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {

    private static final int RANGE_OF_RANDOM_NUMBER = 10;
    private static final int STANDARD_NUMBER_OF_MOVE_FORWARD = 4;

    private static int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

    private final List<Car> cars = new ArrayList<>();

    private Racing() {
    }

    public static Racing of() {
        return new Racing();
    }

    public void drive() {
        IntStream.range(0, cars.size())
                .forEach(idx -> {
                    if (Racing.stopOrMoveForward()) {
                        cars.get(idx).moveForward();
                    }
                });
    }

    public void registerCar(final Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }


    public static boolean stopOrMoveForward() {
        if (generateRandomNumber() >= STANDARD_NUMBER_OF_MOVE_FORWARD) {
            return true;
        }
        return false;
    }
}
