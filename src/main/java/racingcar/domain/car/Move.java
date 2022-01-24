package racingcar.domain.car;

import racingcar.domain.random.RandomFactory;
import racingcar.domain.random.RandomStrategy;

public class Move {

    private static final int BOUND = 4;
    private RandomFactory randomFactory;

    public Move() {
        randomFactory = new RandomFactory();
    }

    public boolean isSatisfiedMoveCondition(RandomStrategy randomStrategy) {
        return randomFactory.getRandom(randomStrategy) >= BOUND;
    }
}
