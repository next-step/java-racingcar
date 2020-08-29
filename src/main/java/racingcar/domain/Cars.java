package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public void move(RandomMove randomMove) {
        cars.stream()
                .filter(car -> randomMove.canMove())
                .forEach(Car::move);
    }

    public List<Car> getCar() {
        return cars;
    }
}

