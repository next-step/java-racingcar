package com.jaeyeonling.racingcar.domain;

public class RacingStrategy extends StandardOverMoveStrategy {

    private static final int MORE_THAN_MOVING_CONDITION = 4;

    @Override
    protected int getStandard() {
        return MORE_THAN_MOVING_CONDITION;
    }
}
