package racing.core.patterns;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int TOTAL_CASES = 10;
    private static final int CONDITION = 4;

    private Random random = new Random();

    @Override
    public boolean canMove() {
        return random.nextInt(TOTAL_CASES) >= CONDITION;
    }
}
