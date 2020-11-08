package racingcar.domain.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StopStrategyTest {

    private StopStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = StopStrategy.getInstance();
    }

    @Test
    @DisplayName("checkMovable 이 false 를 반환해야 한다.")
    void checkMovable() {
        boolean isMovable = strategy.checkMovable();
        boolean expectedMovable = false;
        assertThat(isMovable)
                .isEqualTo(expectedMovable);
    }
}
