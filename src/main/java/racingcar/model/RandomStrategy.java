package racingcar.model;

import java.util.Random;

public class RandomStrategy implements MoveStrategy {

    private static final int RANDOM_BOUND_VALUE = 9;
    private static final int MOVE_FORWARD_CONDITION = 4;

    public boolean canMove() {
        return generateRandomNumber() > MOVE_FORWARD_CONDITION;
    }

    private int generateRandomNumber() {
        return new Random().nextInt(RANDOM_BOUND_VALUE+1);
    }
}
