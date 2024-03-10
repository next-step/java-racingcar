package racinggame.domain;

import java.util.Random;

public class AlwaysMoveCondition extends MoveCondition {

    private static final int LEAST_MOVABLE_CONDITION = 4;
    private static final int MAXIMUM_RANDOM_BOUND = 10;
    private static final Random RANDOM = new Random();

    public AlwaysMoveCondition() {
        super(LEAST_MOVABLE_CONDITION + RANDOM.nextInt(MAXIMUM_RANDOM_BOUND - LEAST_MOVABLE_CONDITION));
    }
}
