package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PositionsTest {
    Position position;

    @BeforeEach
    void init() {
        position = new Position();

    }

    @Test
    void position_초기화값_확인() {
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void move후_position값_확인() {
        position.move();
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
