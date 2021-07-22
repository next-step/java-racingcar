package racingcar.vehicle;

import racingcar.vehicle.engine.CarEngine;
import racingcar.vehicle.engine.Engine;

public class CarFactory {

    private static final Engine DEFAULT_ENGINE = new CarEngine();
    private static final Distance DEFAULT_DISTANCE = new Distance(0);

    public static Car create(String name) {
        return new Car(DEFAULT_ENGINE, name, DEFAULT_DISTANCE);
    }

    public static Car create(String name, int distance) {
        return new Car(DEFAULT_ENGINE, name, new Distance(distance));
    }
}
