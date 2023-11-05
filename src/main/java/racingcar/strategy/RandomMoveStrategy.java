package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int BASE_RANDOM_BOUND = 10;
    private static final int MOVE_CONDITION = 4;
    private static final int MOVE_POSITION = 1;
    private static final int DEFAULT_MOVE_POSITION = 0;
    private final Random random = new Random();

    @Override
    public int moveCondition() {
        int randomNumber = random.nextInt(BASE_RANDOM_BOUND);

        if (randomNumber >= MOVE_CONDITION) {
            return MOVE_POSITION;
        }

        return DEFAULT_MOVE_POSITION;
    }
}
