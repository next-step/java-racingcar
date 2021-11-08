package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.Car;

public class CarHistory {
    private final int position;

    private CarHistory(int position) {
        this.position = position;
    }

    public static CarHistory of(Car car) {
        return new CarHistory(car.getPosition());
    }

    public int getPosition() {
        return position;
    }
}
