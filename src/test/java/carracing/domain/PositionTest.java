package carracing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void positionByNegativeTest() {

        // given
        int input = -1;

        // when & given
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Position(input))
            .withMessageMatching("현재 위치는 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차가 move하면 위치가 1 증가한다.")
    void positionMoveTest() {

        // given
        Position position = new Position();

        // when
        position.move();

        // given
        assertThat(position).isEqualTo(new Position(1));
    }

}