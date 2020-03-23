package racingcar.model;

import java.util.Collections;
import java.util.List;

public final class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
