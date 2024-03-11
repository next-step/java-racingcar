package racinggame.domain;

import java.util.Random;

public class NeverMoveCondition extends MoveCondition {

    private static final int LEAST_MOVABLE_CONDITION = 4;
    private static final Random RANDOM = new Random();

    public NeverMoveCondition() {
        super(RANDOM.nextInt(LEAST_MOVABLE_CONDITION));
    }
}
