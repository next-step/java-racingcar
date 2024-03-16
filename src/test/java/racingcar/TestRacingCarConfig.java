package racingcar;

import static racingcar.domain.movement.BasicRule.FORWARD_CONDITION;

import racingcar.domain.movement.BasicRule;
import racingcar.domain.movement.NumberGenerator;
import racingcar.domain.movement.Rule;

public final class TestRacingCarConfig {

    private TestRacingCarConfig() {
    }

    public static Rule basicRule() {
        return new BasicRule();
    }

    public static NumberGenerator moveForwardNumberGenerator() {
        return () -> FORWARD_CONDITION;
    }

    public static NumberGenerator stopNumberGenerator() {
        return () -> FORWARD_CONDITION - 1;
    }
}
