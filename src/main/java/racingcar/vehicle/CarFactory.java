package racingcar.vehicle;

import racingcar.engine.CarEngine;
import racingcar.engine.Engine;

public class CarFactory {

    private static final Engine DEFAULT_ENGINE = new CarEngine();
    private static final int DEFAULT_DISTANCE = 0;

    public static Car create() {
        return new Car(DEFAULT_ENGINE, DEFAULT_DISTANCE);
    }

    public static Car create(int distance) {
        return new Car(DEFAULT_ENGINE, distance);
    }
}
