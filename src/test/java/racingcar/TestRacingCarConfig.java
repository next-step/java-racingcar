package racingcar;

import static racingcar.domain.movement.BasicRule.FORWARD_CONDITION;

import racingcar.domain.MovementStrategy;
import racingcar.domain.movement.BasicRule;
import racingcar.domain.movement.NumberGenerator;
import racingcar.domain.movement.RandomNumberGenerator;
import racingcar.domain.movement.Rule;

public final class TestRacingCarConfig {

    private TestRacingCarConfig() {
    }

    public static MovementStrategy basicMoveForwardStrategy() {
        return new MovementStrategy(basicRule(), moveForwardNumberGenerator());
    }

    public static MovementStrategy basicStopStrategy() {
        return new MovementStrategy(basicRule(), stopNumberGenerator());
    }

    public static Rule basicRule() {
        return new BasicRule();
    }

    public static NumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public static NumberGenerator moveForwardNumberGenerator() {
        return () -> FORWARD_CONDITION;
    }

    public static NumberGenerator stopNumberGenerator() {
        return () -> FORWARD_CONDITION - 1;
    }
}
