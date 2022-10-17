package racingcar.backend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("AA(5)의 위치 값이 BB(3) 보다 큼")
    void compare_position() {
        assertThat(new Position(5)).isGreaterThan(new Position(3));
    }

    @Test
    @DisplayName("BB(3)의 위치 값이 CC(4) 보다 작음")
    void compare_position2() {
        assertThat(new Position(3)).isLessThan(new Position(4));
    }

    @Test
    @DisplayName("+1 전진")
    void move_forward() {
        assertThat(new Position(2).forward()).isEqualTo(new Position(3));
    }
}
