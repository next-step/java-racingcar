package racingcar.domain;

import racingcar.util.RandomGenerator;

import java.util.Random;

public class RandomMoveStrategy {


    public static final int MOVE_THRESHOLD = 4;
    public static final int BOUND = 10;
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
