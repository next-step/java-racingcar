package racingcar.model;

import racingcar.strategy.MovingStrategy;
import racingcar.util.RandomNumberUtils;

import java.util.Random;

public class Car {
    private int position;
    private MovingStrategy movingStrategy;

    private static int INIT_POSITION = 0;

    public Car(int position) {
        this.position = position;
    }

    public Car() {
        this(INIT_POSITION);
    }

    public int getPosition() {
        return this.position;
    }

    public void setMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void movable() {
        move(movingStrategy.isMovable());
    }


    public void move(boolean isMovable) {
        if (isMovable) {
            this.position += movingStrategy.move();
        }
    }
}
