package racingcar.model;

import racingcar.policy.MovingPolicy;

import java.util.Collections;
import java.util.List;

public final class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public void move(final MovingPolicy movingPolicy) {
        for (Car car : cars) {
            car.move(movingPolicy);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
