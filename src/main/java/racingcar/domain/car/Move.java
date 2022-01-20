package racingcar.domain.car;

import racingcar.domain.random.RandomFactory;
import racingcar.domain.random.RandomStrategy;
import racingcar.domain.random.RandomGenerator;

public class Move {

    private static final int BOUND = 4;
    private RandomFactory randomFactory;

    private Move() {
        randomFactory = new RandomFactory();
    }

    public static Move get() {
        return new Move();
    }

    public boolean isSatisfiedMoveCondition() {
        if (randomFactory.getRandom(new RandomGenerator()) >= BOUND) {
            return true;
        }
        return false;
    }
}
