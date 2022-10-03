package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class PositionsTest {
    Position position;

    @BeforeEach
    void init() {
        position = new Position();

    }

    @Test
    void initPosition() {
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void moveTest() {
        position.move();
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
