package racingcar;

import java.util.Random;

public class Car {
    private final boolean[] moves;

    public Car(int attempts) {
        this.moves = new boolean[attempts];
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
