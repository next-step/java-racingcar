package racingcar.collection;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private final List<Car> cars = new ArrayList<>();

    public void participate(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
