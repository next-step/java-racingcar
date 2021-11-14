package study.racing.model;

import java.util.Collections;
import java.util.List;

import study.racing.model.car.Car;

public class Result {

    private final List<Car> cars;

    public Result(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getResult() {
        return Collections.unmodifiableList(cars);
    }
}
