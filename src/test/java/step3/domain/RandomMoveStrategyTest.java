package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.Fixture.fakeCanMoveStrategy;
import static step3.Fixture.fakeCanNotMoveStrategy;

class RandomMoveStrategyTest {
    @Test
    @DisplayName("정지 전략 확인")
    void canNotMoveStrategy() {
        assertThat(fakeCanNotMoveStrategy.isMovable()).isFalse();
    }

    @Test
    @DisplayName("전진 전략 확인")
    void canMoveStrategy() {
        assertThat(fakeCanMoveStrategy.isMovable()).isTrue();
    }
}