package racingcar.model;

import racingcar.policy.MovingPolicy;

import java.util.Collections;
import java.util.List;

public final class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    // TODO : INDENT 2
    public void move(final MovingPolicy movingPolicy) {
        int distance;
        for (Car car : cars) {
            distance = movingPolicy.distance();
            if (movingPolicy.isPossibleMove(distance)) {
                car.move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
