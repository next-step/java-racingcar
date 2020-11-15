package racingcar.behavior;

import java.util.Random;

public class RandomNumber {
    private final int boundNumber;
    private final Random random = new Random();

    public RandomNumber(int boundNumber) {
        this.boundNumber = boundNumber;
    }

    public int getBoundNumber() {
        return random.nextInt(boundNumber);
    }
}
