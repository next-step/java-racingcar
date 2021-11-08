package racingcar.collection;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarList {
    private final List<Car> cars = new ArrayList<>();

    public void participate(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
