package study.step_3;

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

    public boolean movable() {
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
