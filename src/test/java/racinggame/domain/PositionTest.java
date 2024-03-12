package racinggame.domain;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    @DisplayName("위치 변경 테스트")
    void move() {
        Position position = new Position(5);
        assertThat(position.move()).isEqualTo(new Position(6));
    }

    @Test
    @DisplayName("위치 음수 예외처리 테스트")
    public void position_negative() throws Exception {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(RuntimeException.class);
    }
}
