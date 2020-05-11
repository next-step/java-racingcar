package racingcar;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

    private final int DEFAULT_RANDOM_RANGE = 10;
    private final int MINIMUM_MOVABLE_VALUE = 4;

    private final Random randomGenerator = new Random();

    @Override
    public int move() {
        return movedByNumberFourOrMore();
    }

    public int movedByNumberFourOrMore() {
        int value = randomGenerator.nextInt(DEFAULT_RANDOM_RANGE);
        if(value >= MINIMUM_MOVABLE_VALUE) {
            return 1;
        }
        return 0;
    }
}
