package racingcar.model;

import racingcar.strategy.MovingStrategy;
import racingcar.util.RandomNumberUtils;

import java.util.Random;

public class Car {
    private int position;
    private String name;
    private static int INIT_POSITION = 0;

    public Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(MovingStrategy movingStrategy) {
        this.position += movingStrategy.move();
    }
}
