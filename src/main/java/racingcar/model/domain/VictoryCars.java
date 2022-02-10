package racingcar.model.domain;

import java.util.Collections;
import java.util.List;

public class VictoryCars {

    private final List<Car> victories;

    private VictoryCars(final List<Car> victories) {
        this.victories = victories;
    }

    public static VictoryCars makeVictoryCars(final Cars cars) {
        return new VictoryCars(cars.doMaxCar(findMaxStepCar(cars)));
    }

    private static int findMaxStepCar(final Cars cars) {
        return cars.findMaxStepCars();
    }

    public List<Car> victory() {
        return Collections.unmodifiableList(victories);
    }

}
