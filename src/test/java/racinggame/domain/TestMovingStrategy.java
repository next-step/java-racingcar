package racinggame.domain;

import racinggame.domain.strategy.MovingStrategy;

class TestMovingStrategy implements MovingStrategy {

    public static final boolean DEFAULT_MOVABLE = false;
    private final boolean movable;

    public TestMovingStrategy(boolean movable) {
        this.movable = movable;
    }

    public TestMovingStrategy() {
        this.movable = DEFAULT_MOVABLE;
    }

    @Override
    public boolean movable() {
        return this.movable;
    }

}
