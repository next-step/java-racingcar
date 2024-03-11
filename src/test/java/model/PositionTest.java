package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    void create() {
        Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void create_음수값은_예외를_던진다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 값은 불가합니다");
    }
}
