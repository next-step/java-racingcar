package racingcar;

import java.util.Random;

public class Car {
    private final int SEED = 10;
    private String distance = "";

    public void move() {
        if (randomNumber() >= 4) {
            distance += "-";
        }
    }

    private int randomNumber() {
        return new Random().nextInt(SEED);
    }

    public boolean isMoveForward(int number) {
        return number >= 4;
    }

    public String distanceDriven() {
        return distance;
    }
}
