package racinggame.domain;

import racinggame.domain.strategy.MovingStrategy;

class TestMovingStrategy implements MovingStrategy {

    public static final int DEFAULT_NUMBER = 0;
    private final int number;

    public TestMovingStrategy(int number) {
        this.number = number;
    }

    public TestMovingStrategy() {
        this.number = DEFAULT_NUMBER;
    }

    @Override
    public int nextInt() {
        return this.number;
    }

}
