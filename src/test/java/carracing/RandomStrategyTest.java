package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomStrategyTest {
    private final RandomStrategy randomStrategy = new RandomStrategy();

    @Test
    @DisplayName("0(전진 X) 또는 1(전진 O)을 반환합니다.")
    void testMove() {
        assertThat(randomStrategy.move()).isIn(0, 1);
    }
}