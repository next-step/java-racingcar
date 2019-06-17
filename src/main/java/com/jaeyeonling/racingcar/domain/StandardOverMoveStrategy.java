package com.jaeyeonling.racingcar.domain;

public abstract class StandardOverMoveStrategy implements MoveStrategy {

    protected abstract int getStandard();

    @Override
    public boolean isMove(final int condition) {
        return condition >= getStandard();
    }
}
