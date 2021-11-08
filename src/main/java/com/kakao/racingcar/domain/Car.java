package com.kakao.racingcar.domain;

import com.kakao.racingcar.config.CarConfig;

public class Car {
    private final int identify;
    private int position = 0;

    public Car(int identify) {
        this.identify = identify;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove(int conditionNumber) {
        if (CarConfig.MOVE_PERCENTAGE <= conditionNumber) {
            position++;
        }
    }

    public int getIdentify() {
        return identify;
    }
}
