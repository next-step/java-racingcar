package com.kakao.racingcar.domain.car;

public class RandomStrategy implements MovableStrategy {

    private static final int MOVE_PERCENTAGE = 4;

    @Override
    public boolean move(int conditionNumber) {
        return MOVE_PERCENTAGE <= conditionNumber;
    }
}
