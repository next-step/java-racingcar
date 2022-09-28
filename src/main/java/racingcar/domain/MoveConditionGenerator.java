package racingcar.domain;

import java.util.Random;

public class MoveConditionGenerator {

    private static final MoveCondition canMoveCondition = () -> true;
    private static final MoveCondition cantMoveCondition = () -> false;

    private static final Random random = new Random();
    private static final int RANDOM_ARRANGE = 10;
    private static final int MIN_RANDOM_NUM_CAN_MOVED = 4;

    public static MoveCondition getMoveCondition() {
        if (MIN_RANDOM_NUM_CAN_MOVED <= random.nextInt(RANDOM_ARRANGE)) {
            return canMoveCondition;
        }

        return cantMoveCondition;
    }
}
