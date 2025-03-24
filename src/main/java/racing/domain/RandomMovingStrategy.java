package racing.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MOVE_CONDITION = 4;
    private final int rand;

    public RandomMovingStrategy(int rand) {
        this.rand = rand;
    }

    @Override
    public boolean movable() {
        return new Random().nextInt(rand) >= MOVE_CONDITION;
    }
}
