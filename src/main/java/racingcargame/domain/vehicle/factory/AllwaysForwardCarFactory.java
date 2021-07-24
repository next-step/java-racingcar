package racingcargame.domain.vehicle.factory;

import racingcargame.domain.common.Distance;
import racingcargame.domain.common.Name;
import racingcargame.domain.vehicle.Car;
import racingcargame.domain.vehicle.engine.AllwaysForwardEngine;
import racingcargame.domain.vehicle.engine.Engine;

public class AllwaysForwardCarFactory implements CarFactory {

    private static final Engine ALLWAYS_FORWARD_ENGINE = new AllwaysForwardEngine();
    private static final Distance DEFAULT_DISTANCE = new Distance(0);

    @Override
    public Car create(Name name) {
        return new Car(ALLWAYS_FORWARD_ENGINE, name, DEFAULT_DISTANCE);
    }

    @Override
    public Car create(Name name, Distance distance) {
        return new Car(ALLWAYS_FORWARD_ENGINE, name, distance);
    }
}
