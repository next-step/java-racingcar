package com.kakao.racingcar.domain.car;

import com.kakao.racingcar.config.CarConfig;

public class Car {
    private final String userName;
    private int position = 0;

    public Car(String userName) {
        this.userName = userName;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove(int conditionNumber) {
        if (CarConfig.MOVE_PERCENTAGE <= conditionNumber) {
            position++;
        }
    }

    public String getUserName() {
        return userName;
    }
}
