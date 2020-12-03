package com.nextstep.racinggame.application;

import com.nextstep.racinggame.domain.Cars;
import com.nextstep.racinggame.domain.GasStation;

public class RacingGame {
    public static Cars race(Cars cars, GasStation gasStation) {
        return cars.move(gasStation);
    }
}
