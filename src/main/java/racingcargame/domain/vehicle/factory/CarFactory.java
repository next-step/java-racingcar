package racingcargame.domain.vehicle.factory;

import racingcargame.domain.common.Distance;
import racingcargame.domain.common.Name;
import racingcargame.domain.vehicle.Car;

public interface CarFactory {

    Car create(Name name);

    Car create(Name name, Distance distance);
}
