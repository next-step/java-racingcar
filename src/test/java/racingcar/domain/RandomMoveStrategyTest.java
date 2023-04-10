package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

import static org.junit.jupiter.api.Assertions.*;

class RandomMoveStrategyTest {

    @Test
    @DisplayName("전진 전략 테스트")
    void testIsMovable() {
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy(new RandomNumberGenerator()) {
            @Override
            public boolean isMovable() {
                return true;
            }
        };
        assertTrue(randomMoveStrategy.isMovable());
    }

    @Test
    @DisplayName("정지 전략 테스트")
    void testIsNotMovable() {
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy(new RandomNumberGenerator()) {
            @Override
            public boolean isMovable() {
                return false;
            }
        };

        assertFalse(randomMoveStrategy.isMovable());
    }
}