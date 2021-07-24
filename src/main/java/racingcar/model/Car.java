package racingcar.model;

import racingcar.util.RandomNumberUtils;

import java.util.Random;

public class Car {
    private int position;

    private static int MOVABLE_BOUND = 4;
    private static int INIT_POSITION = 0;

    public Car(int position) {
        this.position = position;
    }

    public Car(){
        this(INIT_POSITION);
    }

    public int getPosition() {
        return this.position;
    }

    private void move() {
        position++;
    }

    private boolean isMovable(int randomNumber) {
        if (randomNumber >= MOVABLE_BOUND) {
            return true;
        }
        return false;
    }

    public void movable(int randomNumber) {
        if (isMovable(randomNumber)) {
            this.move();
        }
    }
}
