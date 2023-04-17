package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private Random random;

    public RandomNumber() {
        this.random = new Random();
    }

    public int calculateRandomNumber() {
        return this.random.nextInt(10);
    }
}
