package racingcar;

import java.util.Random;

public class Car {
    private final Random random;
    private int position = 0;

    public Car() {
        this.random = new Random();
    }

    public Car(Random random) {
        this.random = random;
    }

    public int getPosition() {
        return position;
    }

    public void print() {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void go() {
        if (isMove()) {
            move();
        }
    }

    private void move() {
        this.position++;
    }

    private boolean isMove() {
        return random.nextInt(10) > 3;
    }
}
