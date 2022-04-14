package racingcar.utils;

import java.util.Random;

public final class RandomGenerator {
    private final static int RANDOM_NUMBER_BOUND = 10;
    private final static int RANDOM_NUMBER_MIN = 0;
    private final static int RANDOM_NUMBER_MAX = 9;
    private static final Random RANDOM = new Random();

    public RandomGenerator() {
    }

    public int getOneNumberFrom0to9() {
        int number = RANDOM.nextInt(RANDOM_NUMBER_BOUND) + RANDOM_NUMBER_MIN;
        validate(number);
        return number;
    }

    private void validate(int number) {
        if (number < RANDOM_NUMBER_MIN || number > RANDOM_NUMBER_MAX) {
            throw new IllegalArgumentException("올바르지 않은 랜덤 숫자 값 입니다. number :" + number);
        }
    }
}
