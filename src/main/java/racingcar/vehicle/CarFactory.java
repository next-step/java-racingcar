package racingcar.vehicle;

import racingcar.vehicle.engine.CarEngine;
import racingcar.vehicle.engine.Engine;

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
