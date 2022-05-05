package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @Test
    void 자동차_위치() {
        assertThat(new Position(5).getValue()).isEqualTo(5);
    }

    @Test
    void 자동차_위치_음수() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-5));
    }
}