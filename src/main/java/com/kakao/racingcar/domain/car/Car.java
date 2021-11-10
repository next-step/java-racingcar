package com.kakao.racingcar.domain.car;

public class Car{
    private final String userName;
    private int position = 0;
    private final MovableStrategy movableStrategy;

    public Car(String userName, MovableStrategy movableStrategy) {
        this.userName = userName;
        this.movableStrategy = movableStrategy;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove(int conditionNumber) {
        if (movableStrategy.move(conditionNumber)) {
            position++;
        }
    }

    public String getUserName() {
        return userName;
    }

}
