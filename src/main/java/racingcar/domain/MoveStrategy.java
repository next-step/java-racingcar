package racingcar.domain;

import racingcar.util.NumberGenerator;

public class MoveStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private final NumberGenerator generator;

    public MoveStrategy(NumberGenerator generator) {
        this.generator = generator;
    }

    public boolean isMovable() {
        return generator.generate() >= MOVE_THRESHOLD;
    }
}
