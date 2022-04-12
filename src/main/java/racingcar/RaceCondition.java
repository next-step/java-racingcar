package racingcar;

import java.util.Random;

public class RaceCondition {
    private static final int RANGE_RANDOM_NUMBER = 10;
    private static final Random RANDOM_CONDITION = new Random();

    public int generateCondition() {
        return RANDOM_CONDITION.nextInt(RANGE_RANDOM_NUMBER);
    }

}
