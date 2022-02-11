package racingcar.model;

import java.util.Random;

public class RandomStrategy implements MoveStrategy {

    private static final int RANDOM_BOUND_VALUE = 10;
    private static final int MOVE_FORWARD_CONDITION = 4;
    private static final Random Random = new Random();

    public boolean moveOrNot() {
        return generateRandomNumber() > MOVE_FORWARD_CONDITION;
    }

    private int generateRandomNumber() {
        return Random.nextInt(RANDOM_BOUND_VALUE);
    }
}
