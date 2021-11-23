package study;

import java.util.Random;

public class RandomNumber {
    private static final int CONDITION = 4;
    private static final int BOUND = 10;
    private int value;

    public RandomNumber() {
        Random random = new Random();
        this.value = random.nextInt(BOUND);
    }

    public RandomNumber(int value) {
        this.value = value;
    }

    public boolean valid() {
        return this.value >= CONDITION;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RandomNumber{" +
                "value=" + value +
                '}';
    }
}
