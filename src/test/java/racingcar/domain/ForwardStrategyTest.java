package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ForwardStrategyTest {

    @Test
    void isMovableTrue() {
        MoveStrategy moveStrategy = () -> true;
        assertTrue(moveStrategy.isMovable());
    }

    @Test
    void isMovableFalse() {
        MoveStrategy moveStrategy = () -> false;
        assertFalse(moveStrategy.isMovable());
    }
}