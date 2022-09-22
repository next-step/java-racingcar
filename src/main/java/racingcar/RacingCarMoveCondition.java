package racingcar;

import java.util.Random;

public class RacingCarMoveCondition implements MoveCondition {

    private static final Random random = new Random();
    private static final int RANDOM_ARRANGE = 10;
    private static final int MIN_RANDOM_NUM_CAN_MOVED = 4;
    private final boolean canMove;

    public RacingCarMoveCondition() {
        canMove = MIN_RANDOM_NUM_CAN_MOVED <= random.nextInt(RANDOM_ARRANGE);
    }

    @Override
    public boolean canMove() {
        return canMove;
    }
}
