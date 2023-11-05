package racingcar.strategy;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int BASE_RANDOM_BOUND = 10;
    private static final int MOVE_CONDITION = 4;
    private static final int SUCCESS_MOVE_POSITION = 1;
    private static final int FAIL_MOVE_POSITION = 0;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public int moveCondition() {
        int randomNumber = random.nextInt(BASE_RANDOM_BOUND);

        if (randomNumber >= MOVE_CONDITION) {
            return SUCCESS_MOVE_POSITION;
        }

        return FAIL_MOVE_POSITION;
    }
}
