package racinggame.domain;

import racinggame.utils.RandomGenerator;

public class DefaultEngine implements Engine {
    private static final int STANDARD_OUTPUT = 10;
    private static final int MOVEMENT_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return RandomGenerator.generateUnder(STANDARD_OUTPUT) >= MOVEMENT_CONDITION;
    }
}
