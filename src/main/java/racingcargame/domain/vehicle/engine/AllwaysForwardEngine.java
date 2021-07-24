package racingcargame.domain.vehicle.engine;

import racingcargame.domain.common.Distance;

public class AllwaysForwardEngine implements Engine {

    @Override
    public Distance running() {
        return new Distance(1);
    }
}
