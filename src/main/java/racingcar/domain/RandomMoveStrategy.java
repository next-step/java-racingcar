package racingcar.domain;

import racingcar.util.RandomGenerator;

public class RandomMoveStrategy {


    private static final int MOVE_THRESHOLD = 4;
    private static final int BOUND = 10;
    private final RandomGenerator randomGenerator;


    public RandomMoveStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public boolean movable() {
        if (randomGenerator.generateNumber(BOUND) >= MOVE_THRESHOLD) {
            return true;
        }
        return false;
    }
}
