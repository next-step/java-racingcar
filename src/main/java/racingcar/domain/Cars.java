package racingcar.domain;

import racingcar.domain.movingstrategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final MovingStrategy strategy;

    public Cars(List<Car> cars, MovingStrategy strategy) {
        this.strategy = strategy;
        this.cars.addAll(cars);
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public void race() {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public void saveRecords(List<Record> records) {
        for (Car car : cars) {
            records.add(car.extractRecord());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
