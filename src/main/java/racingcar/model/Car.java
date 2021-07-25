package racingcar.model;

import racingcar.strategy.MovingStrategy;
import racingcar.util.RandomNumberUtils;

import java.util.Random;

public class Car {
    private int position;

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

    public void move(MovingStrategy movingStrategy) {
        this.position += movingStrategy.move();
    }
}
