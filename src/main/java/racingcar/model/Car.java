package racingcar.model;

import java.util.Random;

public class Car {
    public static final int RUN_CONDITION = 4;

    private int position = 0;

    public Car() {
    }

    public void move(int value) {
        if (goOrStop(RUN_CONDITION, value)) {
            plugPosition();
        }
    }

    public void plugPosition() {
        this.position += 1;
    }

    public boolean goOrStop(int condition, int value) {
        return value >= condition;
    }

    public int getPosition() {
        return this.position;
    }
}
