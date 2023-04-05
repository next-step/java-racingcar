package racingcar;

import java.util.Random;

public class Car {

    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    private int position = 0;

    public Car() {
    }

    public void move() {
        if (getRandomNumber() >= FORWARD_NUM) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    protected int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                '}';
    }
}
