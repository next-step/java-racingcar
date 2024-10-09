package racingcar.domain;

import racingcar.util.NumberGenerator;


public class ForwardStrategy implements MoveStrategy {
    private static final int FORWARD_BOUNDARY_NUMBER = 4;
    private final NumberGenerator numberGenerator;

    public ForwardStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        return numberGenerator.generate() >= FORWARD_BOUNDARY_NUMBER;
    }
}
