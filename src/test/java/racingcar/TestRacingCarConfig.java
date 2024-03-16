package racingcar;

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
        return () -> 4;
    }
}
