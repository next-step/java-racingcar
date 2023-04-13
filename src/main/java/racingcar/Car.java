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

    public String distanceDriven() {
        return distance;
    }

    public boolean isMoveForward(int number) {
        return number >= 4;
    }

    private int randomNumber() {
        return new Random().nextInt(SEED);
    }
}
