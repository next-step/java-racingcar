package carracing.model;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy<Integer> {
    private static final Random random = new Random();

    @Override
    public boolean canMove() {
        return GameRule.isGoStraight(random.nextInt(GameRule.RANDOM_LIMIT));
    }
}
