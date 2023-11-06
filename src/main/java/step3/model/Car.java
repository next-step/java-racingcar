package step3.model;

import java.util.Random;

public class Car {

    private static final String MOVE = "-";

    private Moving moving;

    public Car(Moving moving) {
        this.moving = moving;
    }

    public String moving(int randomMovingNumber) {
        moving.move(randomMovingNumber);
        return moving.getMove();
    }

    public int getRandomMovingNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
