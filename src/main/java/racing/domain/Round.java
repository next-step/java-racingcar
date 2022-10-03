package racing.domain;

import racing.rule.move.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Round {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;
    private List<Integer> forwardCountOfCars = new ArrayList<>();

    public Round(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>(cars);
        this.moveStrategy = moveStrategy;
    }

    public void racing() {
        for (Car car : cars) {
            car.move(moveStrategy);
            forwardCountOfCars.add(car.getForwardCount());
        }
    }

    public List<Integer> getForwardCountOfCars() {
        return forwardCountOfCars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}