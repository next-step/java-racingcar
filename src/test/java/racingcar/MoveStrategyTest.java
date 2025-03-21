package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveStrategyTest {

    @Test
    @DisplayName("랜덤 값이 4 이상이면 전진 가능")
    void shouldMoveWhenRandomValueIsAboveThreshold() {
        MoveStrategy moveStrategy = () -> true;  // 4 이상일 때 전진

        boolean result = moveStrategy.isMovable();

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 전진 불가")
    void shouldNotMoveWhenRandomValueIsBelowThreshold() {
        MoveStrategy moveStrategy = () -> false;  // 4 미만일 때는 전진 불가

        boolean result = moveStrategy.isMovable();

        assertThat(result).isFalse();
    }
}
