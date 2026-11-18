package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ThresholdMoveStrategyTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("값이 4 이상이면 전진한다")
    void canMoveIfNumberIsFourOrMore(int value) {
        MoveStrategy moveStrategy = new ThresholdMoveStrategy(() -> value);

        assertThat(moveStrategy.canMove()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("값이 3 이하면 이동하지 않는다")
    void canNotMoveIfNumberIsThreeOrLess(int value) {
        MoveStrategy moveStrategy = new ThresholdMoveStrategy(() -> value);

        assertThat(moveStrategy.canMove()).isFalse();
    }
}
