package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.car.Car;

public class CarHistory {
    private final int position;
    private final String userName;

    private CarHistory(int position, String userName) {
        this.position = position;
        this.userName = userName;
    }

    public static CarHistory of(Car car) {
        return new CarHistory(car.getPosition(), car.getUserName());
    }

    public int getPosition() {
        return position;
    }

    public String getUserName() {
        return userName;
    }
}
