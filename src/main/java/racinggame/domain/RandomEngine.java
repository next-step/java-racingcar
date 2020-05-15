package racinggame.domain;

import java.util.Random;

public class RandomEngine implements Engine {
    private static final int STANDARD_OUTPUT_LIMIT = 10;
    private static final int MOVEMENT_CONDITION = 4;

    public static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(STANDARD_OUTPUT_LIMIT) >= MOVEMENT_CONDITION;
    }
}
