package racingcar;

import java.util.Random;

public class RandomMovable {

    private final int DEFAULT_RANDOM_RANGE = 10;
    private final int MINIMUM_MOVABLE_VALUE = 4;

    private final Random randomGenerator = new Random(DEFAULT_RANDOM_RANGE);

    public int movedByNumberFourOrMore() {
        int value = randomGenerator.nextInt();
        if(value >= MINIMUM_MOVABLE_VALUE) {
            return 1;
        }
        return 0;
    }
}
