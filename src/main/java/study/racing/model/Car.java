package study.racing.model;

import java.util.Random;

public class Car implements Comparable<Car> {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_RANDOM_NUM = 10;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if(canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return getRandomNumber() >= MOVE_THRESHOLD;
    }

    private int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUM);
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.getPosition();
    }
}
