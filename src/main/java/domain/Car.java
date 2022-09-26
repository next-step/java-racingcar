package domain;

import java.util.Random;

public class Car {

    private int position;

    public Car() {
        this(0);
    }
    public Car(int position) {
        this.position = position;
    }

    public int move() {
        if (canMove()) {
            position++;
        }
        return position;
    }

    private boolean canMove() {
        return getIntValue() >= 4;
    }

    private int getIntValue() {
        return new Random().nextInt(10);
    }

    public int getPosition() {
        return position;
    }
}
