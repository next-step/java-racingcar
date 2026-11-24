package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("위치 0을 허용한다.")
    void 위치_0을_허용한다() {
        Position position = new Position(0);

        assertThat(position.getValue()).isZero();
    }

    @Test
    @DisplayName("음수 위치는 허용하지 않는다.")
    void 음수_위치를_거절한다() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진하면 현재 위치가 1 증가한다.")
    void 전진하면_위치가_1_증가한다() {
        Position position = new Position(3);

        position.advance();

        assertThat(position.getValue()).isEqualTo(4);
    }
}
