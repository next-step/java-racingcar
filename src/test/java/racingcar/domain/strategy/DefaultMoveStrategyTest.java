package racingcar.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultMoveStrategyTest {

    MoveStrategy strategy = new DefaultMoveStrategy();

    @DisplayName("0~3은 이동 실패")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void canMove_fail(int number) {
        assertThat(strategy.canMove(number)).isFalse();
    }

    @DisplayName("4~9는 이동 성공")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void canMove_success(int number) {
        assertThat(strategy.canMove(number)).isTrue();
    }
}