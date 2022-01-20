package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {

    private static int generateRandomNumber() {
        return (int) (Math.random() * 10);
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
        if (generateRandomNumber() >= 4) {
            return true;
        }
        return false;
    }
}
