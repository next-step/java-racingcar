package racing;

import org.junit.jupiter.api.Test;
import racing.entity.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {

    @Test
    void positionCorrectly() {
        Position position = new Position(5);
        assertEquals(5, position.getValue());
    }

    @Test
    void positionCannotBeNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Position(-1));
        assertEquals("cannot be negative.", exception.getMessage());
    }

    @Test
    void movePositionCorrectly() {
        Position position = new Position(5);
        Position movedPosition = position.movePosition();
        assertEquals(6, movedPosition.getValue());
    }
}
