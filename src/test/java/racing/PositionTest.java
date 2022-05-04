package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("position 객체 생성 확인")
    @Test
    void create() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position("1"));
    }

    @DisplayName("position 객체 validation")
    @Test
    void invalid() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수를 입력할 수 없습니다.");
    }
}
