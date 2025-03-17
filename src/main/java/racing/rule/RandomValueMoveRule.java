package racing.rule;

import java.util.Random;

public class RandomValueMoveRule extends MoveRule {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 9; // random 최대값

    @Override
    public boolean isMovable() {
        return getRandomValue() >= MIN_MOVE_VALUE;
    }

    private static int getRandomValue() {
        return RANDOM.nextInt(MAX_RANDOM_VALUE);
    }
}
