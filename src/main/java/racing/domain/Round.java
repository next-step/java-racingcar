package racing.domain;

import racing.rule.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Round {

    List<Integer> forwardCountOfCars = new ArrayList<>();
    List<Car> cars;

    public void racing(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        cars.stream().forEach(car -> {
            car.move(moveStrategy);
            forwardCountOfCars.add(car.getForwardCount());
        });
    }

    public List<Integer> getForwardCountOfCars() {
        return forwardCountOfCars;
    }

    public List<Car> getCars() {
        return cars;
    }
}