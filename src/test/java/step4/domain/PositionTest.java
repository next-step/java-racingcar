package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @DisplayName("위치가 음수로 생성되면 IllegalArgumentException 발생한다.")
    @Test
    void negative_position() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Position(-1);
        });
    }

    @DisplayName("위치값이 증가한다.")
    @Test
    void increase_position() {
        // given
        int initialPosition = 0;
        Position position = new Position(initialPosition);

        // when
        position.increase();

        //then
        assertThat(position.getPosition()).isEqualTo(initialPosition + 1);
    }
}