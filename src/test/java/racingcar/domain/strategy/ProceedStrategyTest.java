package racingcar.domain.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProceedStrategyTest {

    private ProceedStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = ProceedStrategy.getInstance();
    }

    @Test
    @DisplayName("checkMovable 이 true 를 반환해야한다.")
    void checkMovable() {
        boolean isMovable = strategy.checkMovable();
        boolean expectedMovable = true;
        assertThat(isMovable)
                .isEqualTo(expectedMovable);
    }
}
