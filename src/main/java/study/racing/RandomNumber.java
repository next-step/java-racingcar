package study.racing;

import java.util.Random;

public class RandomNumber {
    private final Random random;

    public RandomNumber() {
        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(10);
    }

}
