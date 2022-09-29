package racingcar;

import java.util.Random;

public class Car {
    private static final Random random = new Random();
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void go() {
        if (isMove()) {
            move();
        }
    }

    public void move() {
        this.position++;
    }

    private boolean isMove() {
        return random.nextInt(10) > 3;
    }
}
