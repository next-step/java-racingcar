package racingcar.domain.moving;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositionTest {

    @Test
    @DisplayName("앞으로 이동하는지 확인한다")
    void testForward() {
        // given
        Position position = Position.of(0);
        // when
        Position nextPosition = position.move(() -> true);
        // then
        assertThat(nextPosition.get()).isEqualTo(1);
    }

    @Test
    @DisplayName("0보다 작은 위치인경우 예외를 확인한다")
    void testIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    Position.of(-1);
                // then
                }).withMessageMatching("invalid position");
    }

    @Test
    @DisplayName("현재위치가 최대위치와 같은지 확인한다")
    void testMaxPosition2() {
        // given
        Position position = Position.of(10);
        // when
        boolean maxPosition = position.isSamePosition(10);
        // then
        assertTrue(maxPosition);
    }
}
