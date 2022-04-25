package step3.car;

import java.util.Random;

public class Car {

    private static final Random random = new Random();
    private static final int CAN_MOVE_MIN_NUMBER = 4;
    private int state;

    private Car() {
        random.setSeed(System.currentTimeMillis());
    }

    public static Car of() {
        return new Car();
    }

    public int getState() {
        return this.state;
    }

    public void move() {
        move(canMove());
    }

    public void move(boolean move) {
        if (move) {
            this.state++;
        }
    }

    private boolean canMove() {
        return random() >= CAN_MOVE_MIN_NUMBER;
    }

    private int random() {
        return random.nextInt(10);
    }
}
