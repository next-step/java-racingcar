package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class RandomMoveStrategy implements MoveStrategy {

    private final RandomNumberGenerator numberGenerator;
    private static final int CONDITIONAL_VALUE = 4;

    public RandomMoveStrategy(RandomNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        return numberGenerator.generate() >= CONDITIONAL_VALUE;
    }
}
