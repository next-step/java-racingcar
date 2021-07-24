package racingcargame.domain.vehicle.factory;

import racingcargame.domain.common.Distance;
import racingcargame.domain.common.Name;
import racingcargame.domain.vehicle.Car;
import racingcargame.domain.vehicle.engine.CarEngine;
import racingcargame.domain.vehicle.engine.Engine;

public class NormalCarFactory implements CarFactory {

    private static final Engine NORMAL_ENGINE = new CarEngine();
    private static final Distance DEFAULT_DISTANCE = new Distance(0);

    @Override
    public Car create(Name name) {
        return new Car(NORMAL_ENGINE, name, DEFAULT_DISTANCE);
    }

    @Override
    public Car create(Name name, Distance distance) {
        return new Car(NORMAL_ENGINE, name, distance);
    }
}
