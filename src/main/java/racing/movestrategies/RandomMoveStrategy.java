package racing.movestrategies;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MAX_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    private final Random random = new Random();

    @Override
    public boolean canIMove() {
        return random.nextInt(MAX_BOUND) >= MOVE_THRESHOLD;
    }
}
