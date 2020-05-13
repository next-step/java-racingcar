package com.nextstep.racingcar.domain.car;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Power MIN_POWER = Power.generateByInt(4);

    public boolean isMoveable(Power power) {
        return MIN_POWER.compareTo(power) <= 0;
    }
}
