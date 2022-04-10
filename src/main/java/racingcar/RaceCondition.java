package racingcar;

import java.util.Random;

public class RaceCondition {
    private static final int includeRangeRandomNumber = 1;
    private static final int RANGE_START_RANDOM_NUMBER = 0;
    private static final int RANGE_END_RANDOM_NUMBER = 9;
    private static final Random RANDOM_CONDITION = new Random();

    public int generateCondition() {
        return RANDOM_CONDITION.nextInt(RANGE_END_RANDOM_NUMBER + includeRangeRandomNumber)
                + RANGE_START_RANDOM_NUMBER;
    }
}
