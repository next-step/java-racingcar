package racingcar.domain.strategy;

public class MockRandomMovingStrategy implements MovingStrategy {

    public static final MockRandomMovingStrategy MOVABLE_RANDOM_MOVE_STRATEGY
            = new MockRandomMovingStrategy(RandomMovingStrategy.MOVE_CONSTRAINTS);

    public static final MockRandomMovingStrategy IMMOVABLE_RANDOM_MOVE_STRATEGY
            = new MockRandomMovingStrategy(RandomMovingStrategy.MOVE_CONSTRAINTS - 1);

    private int value;

    public MockRandomMovingStrategy(int value) {
        this.value = value;
    }

    @Override
    public boolean movable() {
        return value >= RandomMovingStrategy.MOVE_CONSTRAINTS;
    }
}
