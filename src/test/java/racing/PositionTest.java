package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Position;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    void positionTest() {
        Position position = new Position();
        Position expected = new Position();
        assertThat(position).isEqualTo(expected);
    }

    @Test
    void initialPositionTest() {
        Position position = new Position();
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void movePositionTest() {
        Position position = new Position();
        position.move();
        position.move();
        assertThat(position.getPosition()).isEqualTo(2);
    }
}
