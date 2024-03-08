package racinggame.domain;

import java.util.Random;

public class MoveCondition {

    private static final int LEAST_MOVABLE_CONDITION = 4;
    private static final int MAXIMUM_RANDOM_BOUND = 10;
    private static final Random random = new Random();
    private int condition;

    public MoveCondition() {
        this(random.nextInt(MAXIMUM_RANDOM_BOUND));
    }

    public MoveCondition(int condition) {
        this.condition = condition;
    }

    public boolean isMovable() {
        return this.condition >= LEAST_MOVABLE_CONDITION;
    }

}
