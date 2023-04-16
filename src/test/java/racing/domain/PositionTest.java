package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    @DisplayName("Position 값 확인")
    void position() {
        // given
        int input = 3;
        Position position1 = new Position(input);
        Position position2 = new Position();

        // when
        assertThat(position1).isEqualTo(new Position(input));
        assertThat(position2).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("음수값 입력시 예외처리")
    void negativePosition() {
        // given
        int input = -1;

        // when
        assertThatThrownBy(() -> new Position(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 위치는 0 이상이어야 합니다.");
    }

    @Test
    @DisplayName("Position 값 증가 확인")
    void positionMove() {
        // given
        int input = 3;
        Position position = new Position(input);

        // when
        Position newPosition = position.increase(1);

        // then
        assertThat(newPosition).isEqualTo(new Position(input + 1));
    }
}