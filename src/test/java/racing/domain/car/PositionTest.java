package racing.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    void 음수값은_위치값이_될_수_없다() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
