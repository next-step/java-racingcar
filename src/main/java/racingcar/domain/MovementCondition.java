package racingcar.domain;

import java.util.Random;

public class MovementCondition {

    private static final Random randomGenerator = new Random();
    private static final int UPPER_BOUND = 10;
    private static final int THRESHOLD = 4;

    public boolean satisfies() {
        int randomNumber = randomGenerator.nextInt(UPPER_BOUND);
        return randomNumber >= THRESHOLD;
    }
}