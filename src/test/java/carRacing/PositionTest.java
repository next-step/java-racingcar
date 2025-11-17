package carRacing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    void 생성자_음수값_제한() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(RuntimeException.class);
    }
}