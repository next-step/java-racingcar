package carracing.model;

import java.util.Random;

import carracing.GameRule;

public class RandomMovableStrategy implements MovableStrategy<Integer> {
    private static final Random random = new Random();
    
    @Override
    public Integer getCondition() {
        return random.nextInt(GameRule.RANDOM_LIMIT);
    }

    @Override
    public boolean predicate(Integer condition) {
        return GameRule.isGoStraight(condition);
    }
}
