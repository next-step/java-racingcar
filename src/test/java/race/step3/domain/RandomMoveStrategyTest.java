package race.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.step3.Fixture;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {
    @Test
    @DisplayName("정지 전략 확인")
    void canNotMoveStrategy() {
        Assertions.assertThat(Fixture.fakeCanNotMoveStrategy.isMovable()).isFalse();
    }

    @Test
    @DisplayName("전진 전략 확인")
    void canMoveStrategy() {
        Assertions.assertThat(Fixture.fakeCanMoveStrategy.isMovable()).isTrue();
    }
}