package com.jaeyeonling.racingcar.domain;

public class RacingStrategy implements MoveStrategy {

    static final int MORE_THAN_MOVING_CONDITION = 4;

    @Override
    public boolean isMove(final int condition) {
        return condition >= MORE_THAN_MOVING_CONDITION;
    }
}
