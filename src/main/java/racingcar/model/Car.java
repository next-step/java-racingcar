package racingcar.model;

import java.util.Random;

public class Car {

    public static final int RUN_CONDITION = 4;
    public static final int RANDOM_RANGE = 10;

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void move() {
        if (goOrStop(RUN_CONDITION, getRandomValue())) {
            plugPosition();
        }
    }

    public void plugPosition() {
        this.position += 1;
    }

    public boolean goOrStop(int condition, int value) {
        return value >= condition;
    }

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }

    public int getPosition() {
        return this.position;
    }
}
