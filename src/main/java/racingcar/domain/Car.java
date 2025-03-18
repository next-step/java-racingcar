package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car {
    private String name;
    private int moveCount;

    public Car() {
        this.moveCount = 1;
    }

    public Car(String name) {
        this.name = name;
        this.moveCount = 1;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }


    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            moveCount++;
        }
    }





}
