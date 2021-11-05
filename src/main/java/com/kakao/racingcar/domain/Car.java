package com.kakao.racingcar.domain;

public class Car {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void tryMove(int conditionNumber) {
        if (CarConfig.MOVE_PERCENTAGE <= conditionNumber) {
            position++;
        }
    }
}
