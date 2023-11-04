package racinggame.domain;

import racinggame.domain.strategy.MovingStrategy;

public class MovingValidator {

    public static final int MIN_MOVABLE_NUMBER = 3;
    private final MovingStrategy movingStrategy;

    public MovingValidator(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public boolean movable() {
        return movingStrategy.nextInt() > MIN_MOVABLE_NUMBER;
    }

}
