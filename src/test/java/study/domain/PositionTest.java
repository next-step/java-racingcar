package study.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {

    @Test
    void positionSetTest() {
        Position position = new Position(3);

        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    void positionValidationTest() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }

    @Test
    void movePositionTest() {
        Position position = new Position(1);
        position.move();

        assertThat(position.getPosition()).isEqualTo(2);
    }
}
