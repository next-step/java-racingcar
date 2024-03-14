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
        Position position = Position.create();
        assertThat(position.move()).isEqualTo(Position.create().move());
    }
}
