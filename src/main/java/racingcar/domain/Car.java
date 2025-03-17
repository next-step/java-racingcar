package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car {
    private int moveCount;

    public Car() {
        this.moveCount = 1;
    }

    public int getMoveCount() {
        return moveCount;
    }


    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.isMove()){
            moveCount++;
        }
    }

}
