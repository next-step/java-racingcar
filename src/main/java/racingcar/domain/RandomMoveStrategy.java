package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int ALLOWABLE_MAXIMUM_NUMBER = 10;
    private static final int ALLOWABLE_MINIMUM_NUMBER = 4;
    private Random random = new Random();

    @Override
    public boolean canMove() {
        int randomNumber = random.nextInt(ALLOWABLE_MAXIMUM_NUMBER);
        return randomNumber >= ALLOWABLE_MINIMUM_NUMBER;
    }
}
