package com.nextstep.racinggame.application;

import com.nextstep.racinggame.domain.Cars;
import com.nextstep.racinggame.domain.MovePolicy;

public class RacingGame {
    public static Cars race(final Cars cars, final MovePolicy movePolicy) {
        return cars.move(movePolicy);
    }
}
