package study.step_3;

import java.util.Random;

public class RandomNumber {
    private static final int BOUND = 10;
    private int value;

    public RandomNumber() {
        Random random = new Random();
        this.value = random.nextInt(BOUND);
    }

    public int getValue() {
        return value;
    }
}
