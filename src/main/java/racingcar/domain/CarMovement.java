package racingcar.domain;

import racingcar.domain.movement.MovingStrategy;
import racingcar.domain.movement.NumberGenerator;

public class CarMovement {

    private final MovingStrategy movingStrategy;
    private final NumberGenerator numberGenerator;

    public CarMovement(final MovingStrategy movingStrategy, final NumberGenerator numberGenerator) {
        this.movingStrategy = movingStrategy;
        this.numberGenerator = numberGenerator;
    }

    public boolean movable() {
        final int condition = numberGenerator.generate();

        return movingStrategy.movable(condition);
    }
}
