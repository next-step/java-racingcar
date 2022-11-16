package racingcar;

import java.util.Random;

public class RandomNumberMovingStrategy {
    private static final int RANDOM_NUMBER_BOUND = 9;
    private static final int NUMBER_FOR_DECISION_OF_STRAIGHT = 4;

    private static final Random RANDOM = new Random();

    private static int getRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }

    public static int move() {
        if(getRandomNumber() >= NUMBER_FOR_DECISION_OF_STRAIGHT) {
            return 1;
        }
        return 0;
    }
}
