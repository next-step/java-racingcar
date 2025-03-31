package racingcar.domain;

public class MoveStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private final NumberGenerator generator;

    public MoveStrategy() {
        this.generator = new RandomNumberGenerator();
    }

    public MoveStrategy(NumberGenerator generator) {
        this.generator = generator;
    }

    public boolean isMovable() {
        return generator.generate() >= MOVE_THRESHOLD;
    }
}
