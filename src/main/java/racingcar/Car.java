package racingcar;

import racingcar.strategy.MovableStrategy;

public class Car {

    private int position = 0;
    private final MovableStrategy movableStrategy;
    public Car(MovableStrategy movableStrategy){
        this.movableStrategy = movableStrategy;
    }

    public void move() {
        if (movableStrategy.canMove()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
