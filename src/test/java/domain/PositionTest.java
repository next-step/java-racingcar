package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void 자동차_위치_생성() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    void 자동차_위치_음수_예외발생() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
