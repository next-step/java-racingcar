package racingcar.domain;

import java.util.Random;

public class Car {

    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    private int position = 0;

    public void move() {
        if (getRandomNumber() >= FORWARD_NUM) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
