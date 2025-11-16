package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("위치는 move() 호출 시 1칸 증가한다")
    @Test
    void positionMove() {
        assertThat(new Position(0).move()).isEqualTo(new Position(1));
    }

    @DisplayName("값이 음수일 경우 예외가 발생한다")
    @Test
    void negativeInputThrowsException() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수");
    }
}