package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    @DisplayName("Position 가 객체의 동등 조건을 만족한다.")
    void createTest() {
        Position position = new Position(4);
        assertThat(position).isEqualTo(new Position(4));
    }

    @Test
    @DisplayName("음수가 전달되었을 때 Position 객체가 생성 시 예외가 발생한다.")
    void throwExceptionWhenNegativePosition() {
        assertThatThrownBy(() -> new Position(-4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수가 전달되어 객체를 생성할 수 없습니다.");
    }
}
