package racing;

import java.util.Random;

public class RandomMoveCondition implements MoveCondition {

    private static final int BOUND = 9;
    private static final int FORWARD_CONDITION = 4;

    private static final Random random = new Random();

    @Override
    public boolean move() {
        return random() >= FORWARD_CONDITION;
    }

    private int random() {
        return random.nextInt(BOUND);
    }
}
