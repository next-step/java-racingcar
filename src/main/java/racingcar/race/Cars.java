package racingcar.race;

import racingcar.rule.Rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void move(Rule rule) {
        for (Car car : cars) {
            moveCar(rule, car);
        }
    }

    private void moveCar(Rule rule, Car car) {
        if(movable(rule)) car.move();
    }

    private boolean movable(Rule rule) {
        return rule.verify();

    }

    public List<Car> list() {
        return Collections.unmodifiableList(cars);
    }
}
