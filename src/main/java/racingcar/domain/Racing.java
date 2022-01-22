package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {

    private final static int MAX_RANDOM_RANGE = 10;
    private final static int MIN_BOUND_STRAIGHT = 4;

    private static int generateRandomNumber() {
        return (int) (Math.random() * MAX_RANDOM_RANGE);
    }

    private final List<Car> cars = new ArrayList<>();

    private Racing() {
    }

    public static Racing get() {
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
        if (generateRandomNumber() >= MIN_BOUND_STRAIGHT) {
            return true;
        }
        return false;
    }
}
