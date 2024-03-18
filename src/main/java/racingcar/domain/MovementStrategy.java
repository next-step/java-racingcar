package racingcar.domain;

import racingcar.domain.movement.NumberGenerator;
import racingcar.domain.movement.Rule;

public class MovementStrategy {

    private final Rule rule;
    private final NumberGenerator numberGenerator;

    public MovementStrategy(final Rule rule, final NumberGenerator numberGenerator) {
        this.rule = rule;
        this.numberGenerator = numberGenerator;
    }

    public boolean canMoveForward() {
        final int condition = numberGenerator.generate();

        return rule.movable(condition);
    }
}
