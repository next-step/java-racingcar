package com.kakao.racingcar.domain.car;

public class Car implements CarMovement{
    private final String userName;
    private int position = 0;

    private static final int MOVE_PERCENTAGE = 4;

    public Car(String userName) {
        this.userName = userName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void tryMove(int conditionNumber) {
        if (MOVE_PERCENTAGE <= conditionNumber) {
            position++;
        }
    }

    public String getUserName() {
        return userName;
    }
}
