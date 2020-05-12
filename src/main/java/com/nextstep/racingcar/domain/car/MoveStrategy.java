package com.nextstep.racingcar.domain.car;

public class MoveStrategy {
    private static final Power MIN_POWER = Power.generateByInt(4);

    public static boolean isMoveable(Power power) {
        return MIN_POWER.compareTo(power) <= 0;
    }
}
