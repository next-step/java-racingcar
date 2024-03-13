package carracing.model.car.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomStrategyTest {
    private final RandomStrategy randomStrategy = new RandomStrategy();

    @Test
    @DisplayName("isMovable(): 랜덤 값에 따라 true 또는 false를 반환합니다.")
    void testIsMovable() {
        assertThat(randomStrategy.isMovable()).isIn(true, false);
    }
}