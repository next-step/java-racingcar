package step3.model;

import java.util.Random;

public class Car {

    private static final int MINIMUM_RANDOM_NUMBER = 4;
    private Moving moving;

    public Car(Moving moving) {
        this.moving = moving;
    }

    public Moving getMoving() {
        return moving;
    }

    public void move(Integer randomNumber) {
        if (randomNumber >= MINIMUM_RANDOM_NUMBER) {
            moving.move(randomNumber);
        }
    }
}
