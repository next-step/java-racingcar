package com.kakao.racingcar.domain.car;

import com.kakao.racingcar.history.CarHistory;

public class Car {
    private final UserName userName;
    private final Position position = new Position();
    private final MovableStrategy movableStrategy;

    public Car(String userName, MovableStrategy movableStrategy) {
        this.userName = new UserName(userName);
        this.movableStrategy = movableStrategy;
    }

    public CarHistory tryMove(int conditionNumber) {
        if (movableStrategy.move(conditionNumber)) {
            position.moveOne();
        }
        return new CarHistory(position.getValue(), userName.getValue());
    }

}
