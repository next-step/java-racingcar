package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {

    private final List<Car> cars = new ArrayList<>();

    private Racing() {
    }

    public static Racing instance() {
        return new Racing();
    }

    public void drive() {
        IntStream.range(0, cars.size())
                .forEach(idx -> cars.get(idx).moveForward());
    }

    public void registerCar(final Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

}
