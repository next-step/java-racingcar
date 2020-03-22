package racingcar;

import java.util.Random;

public class RandomNumber {
    public static final int NUMBER_GENERATE_RANGE = 9;
    private final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(NUMBER_GENERATE_RANGE);
    }
}

