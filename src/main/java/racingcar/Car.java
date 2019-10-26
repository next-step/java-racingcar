package racingcar;

import java.util.Random;

public class Car {

    private int location;
    private Random random;

    Car() {
        this.location = 0;
        this.random = new Random();
    }

    void move() {

        if (isPossibleMove()) {
            this.location++;
        }
    }

    private boolean isPossibleMove() {
        return random.nextInt(10) >= 4;
    }

    int getLocation() {
        return location;
    }
}
