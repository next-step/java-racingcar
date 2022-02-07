package racingcar.model.domain;

import java.util.Collections;
import java.util.List;

public class Victory {

    private final List<Car> victories;

    private Victory(final List<Car> victories) {
        this.victories = victories;
    }

    public static Victory makeVictoryCars(final Cars cars) {
        return new Victory(cars.doMaxCar(findMaxStepCar(cars)));
    }

    private static int findMaxStepCar(final Cars cars) {
        return cars.findMaxStepCars();
    }

    public List<Car> victory() {
        return Collections.unmodifiableList(victories);
    }

}
