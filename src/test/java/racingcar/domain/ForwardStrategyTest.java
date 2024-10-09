package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ForwardStrategyTest {

    @Test
    void isMovableTrue() {
        MoveStrategy moveStrategy = new ForwardStrategy(new RandomNumberGenerator()) {

            @Override
            public boolean isMovable() {
                return true;
            }
        };
        assertTrue(moveStrategy.isMovable());
    }

    @Test
    void isMovableFalse() {
        MoveStrategy moveStrategy = new ForwardStrategy(new RandomNumberGenerator()) {
            @Override
            public boolean isMovable() {
                return false;
            }
        };

        assertFalse(moveStrategy.isMovable());
    }
}