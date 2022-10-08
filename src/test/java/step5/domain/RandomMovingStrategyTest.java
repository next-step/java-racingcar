package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingStrategyTest {

    MovingStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new RandomMovingStrategy();
    }

    @Test
    @DisplayName("값이 4 이상이면 true 반환")
    void isMovableTrue() {
        assertThat(strategy.isMovable(4))
                .isTrue();
    }

    @Test
    @DisplayName("값이 4 미만이면 false 반환")
    void isMovableFalse() {
        assertThat(strategy.isMovable(3))
                .isFalse();
    }
}
