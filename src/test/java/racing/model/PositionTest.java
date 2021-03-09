package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("포지션 이동 테스트")
    @Test
    void move() {
        Position position = new Position(0);

        position.move();

        assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("포지션이 음수 테스트")
    @Test
    void positionValid() {

        assertThatThrownBy(() -> {
            Position position = new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("포지션은 음수일 수 없습니다.");
    }
}