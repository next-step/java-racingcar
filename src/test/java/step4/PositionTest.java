package step4;

import org.junit.jupiter.api.Test;
import step4.model.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void create() {
        Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void move() {
        Position position = new Position(0);
        Position newPosition = position.move();
        assertThat(newPosition).isEqualTo(new Position(1));
    }
}