package racingcargame.domain.vehicle.factory;

import racingcargame.domain.common.Distance;
import racingcargame.domain.common.Name;
import racingcargame.domain.vehicle.Car;
import racingcargame.domain.vehicle.engine.AlwaysForwardEngine;
import racingcargame.domain.vehicle.engine.Engine;

public class AlwaysForwardCarFactory implements CarFactory {

    private static final Engine ALWAYS_FORWARD_ENGINE = new AlwaysForwardEngine();
    private static final Distance DEFAULT_DISTANCE = new Distance(0);

    @Override
    public Car create(Name name) {
        return new Car(ALWAYS_FORWARD_ENGINE, name, DEFAULT_DISTANCE);
    }

    @Override
    public Car create(Name name, Distance distance) {
        return new Car(ALWAYS_FORWARD_ENGINE, name, distance);
    }
}
