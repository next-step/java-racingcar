package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    private Cars() {
    }

    public static Cars of() {
        return new Cars();
    }

    public void drive() {
        IntStream.range(0, cars.size())
                .forEach(idx -> {
                    if (Racing.stopOrMoveForward())
                        cars.get(idx).moveForward();
                });
    }

    public void registerCar(final Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
