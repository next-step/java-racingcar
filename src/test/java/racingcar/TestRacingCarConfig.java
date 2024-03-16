package racingcar;

import racingcar.domain.movement.BasicMovingStrategy;
import racingcar.domain.movement.MovingStrategy;
import racingcar.domain.movement.NumberGenerator;

public final class TestRacingCarConfig {

    private TestRacingCarConfig() {
    }

    public static MovingStrategy basicMovingStrategy() {
        return new BasicMovingStrategy();
    }

    public static NumberGenerator moveForwardNumberGenerator() {
        return () -> 4;
    }
}
