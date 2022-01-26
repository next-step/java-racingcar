package racingcar.model.domain;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.entity.Car;

public class Racing {

    private final static int MAX_RANDOM_RANGE = 10;
    private final static int MIN_BOUND_STRAIGHT = 4;
    private List<Car> cars;

    private Racing(List<Car> cars) {
        this.cars = cars;
    }

    public static Racing get(List<Car> cars) {
        return new Racing(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void drive() {
        IntStream.range(0, cars.size())
            .forEach(idx -> {
                racingCondition(idx);
            });
    }

    public void racingCondition(int idx) {
        if (Racing.stopOrMoveForward()) {
            cars.get(idx).moveForward();
        }
    }

    public static boolean stopOrMoveForward() {
        return generateRandomNumber() >= MIN_BOUND_STRAIGHT;
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * MAX_RANDOM_RANGE);
    }
}

