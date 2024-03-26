package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void 생성() {
        Position position = new Position(4);
        assertThat(position.getPosition()).isEqualTo(4);
    }
}
