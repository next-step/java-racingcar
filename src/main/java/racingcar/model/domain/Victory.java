package racingcar.model.domain;

import java.util.Collections;
import java.util.List;

public class Victory {

    private final List<Car> victories;

    private Victory(final List<Car> victories) {
        this.victories = victories;
    }

    public static Victory maxCheck(final Cars cars) {

        int max = maxDriveLength(cars);
        return new Victory(cars.carMaxCheck(max));
    }

    private static int maxDriveLength(final Cars cars) {
        return cars.carMaxDistanceCount();
    }

    public List<Car> victory() {
        return Collections.unmodifiableList(victories);
    }

}
