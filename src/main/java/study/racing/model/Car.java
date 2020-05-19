package study.racing.model;

import java.util.Random;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_RANDOM_NUM = 10;

    private String name;
    private int count = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void move() {
        if(canMove()) {
            count++;
        }
    }

    private boolean canMove() {
        return getRandomNumber() >= MOVE_THRESHOLD;
    }

    private int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUM);
    }
}
