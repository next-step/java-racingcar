package racingcar.domain;

import racingcar.util.RandomGenerator;

public class RandomMoveStrategy implements MoveStrategy{


    private static final int MOVE_THRESHOLD = 4;
    private static final int BOUND = 10;
    private final RandomGenerator randomGenerator;


    public RandomMoveStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }


    @Override
    public boolean movable() {
        return randomGenerator.generateNumber(BOUND) >= MOVE_THRESHOLD;
    }
}
