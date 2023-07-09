package racingcar.car.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomMoveStrategyTest {


    @Test
    @DisplayName("움직임이 가능한지 여부를 반환한다.")
    void isMovable_doesNotThrowAndReturnBoolean() {
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        assertDoesNotThrow(moveStrategy::isMovable);
        assertInstanceOf(Boolean.class, moveStrategy.isMovable());
    }
}