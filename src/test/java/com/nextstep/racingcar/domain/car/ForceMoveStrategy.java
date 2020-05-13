package com.nextstep.racingcar.domain.car;

public class ForceMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMoveable(Power power) {
        return true;
    }
}
