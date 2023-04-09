package game;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

    private int min;
    private int max;

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator range() {
        return new RandomNumberGenerator();
    }

    public RandomNumberGenerator min(int min) {
        this.min = min;
        return this;
    }

    public RandomNumberGenerator max(int max) {
        this.max = max;
        return this;
    }

    public int getNumber() {
        throwIfInvalidRange();
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private void throwIfInvalidRange() {
        if (min > max) {
            throw new IllegalStateException(String.format("min(%s) 값이 max(%s)값 보다 클수 없습니다.", min, max));
        }
    }
}