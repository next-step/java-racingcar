package racing.domain;

import java.util.Random;

public class RandomMovement implements CarMovement {
    private static final int RANDOM_VALUE = 10;
    private static final int MOVEMENT_CONDITION = 4;

    private Random random;

    public RandomMovement(Random random) {
        this.random = random;
    }

    @Override
    public boolean isMove() {
        return this.random.nextInt(RANDOM_VALUE) >= this.MOVEMENT_CONDITION;
    }
}
