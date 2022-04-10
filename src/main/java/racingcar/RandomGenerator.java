package racingcar;

import java.util.Random;

public final class RandomGenerator {
    private static final Random RANDOM = new Random();
    private final int bound;
    private final int min;
    private final int max;

    RandomGenerator(int start, int bound) {
        this.bound = bound;
        this.min = start;
        this.max = start + bound - 1;
    }

    public int generate() {
        int number = RANDOM.nextInt(bound) + min;
        validate(number);
        return number;
    }

    private void validate(int number) {
        if (number < min || number > max) {
            throw new IllegalArgumentException("올바르지 않은 랜덤 숫자 값 입니다. number :" + number);
        }
    }
}
