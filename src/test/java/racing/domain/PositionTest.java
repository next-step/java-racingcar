package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName(value = "전진")
    void test1() {
        Position position = new Position(3);
        position.move();
        assertThat(position.getPosition()).isEqualTo(4);
    }
}
