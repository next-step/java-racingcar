package study.racing.model.car;

import java.util.ArrayList;
import java.util.List;

import study.racing.model.rule.Rule;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void race(Rule rule) {
        cars.forEach(car -> car.moveOrStop(rule));
    }

    public List<Car> result() {
        return cars;
    }
}
