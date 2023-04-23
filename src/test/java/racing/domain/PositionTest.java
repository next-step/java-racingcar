package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName(value = "전진")
    void 전진() {
        Position position = new Position(3);
        assertThat(position.move()).isEqualTo(new Position(4));
    }
}
