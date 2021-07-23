package racingcar.domain.vehicle;

import racingcar.domain.engine.CarEngine;
import racingcar.domain.engine.Engine;

public class CarFactory {

    private static final Engine DEFAULT_ENGINE = new CarEngine();
    private static final int DEFAULT_DISTANCE = 0;

    private CarFactory() {
    }

    public static Car create(String name) {
        return new Car(DEFAULT_ENGINE, name, new Distance(DEFAULT_DISTANCE));
    }

    public static Car create(String name, int distance) {
        return new Car(DEFAULT_ENGINE, name, new Distance(distance));
    }
}
