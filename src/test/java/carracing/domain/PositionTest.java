package carracing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    public void createPosition() {
        Position position = new Position(5);
        assertThat(position.getPosition()).isEqualTo(new Position(5));
    }

    @Test
    public void move() {
        Position position = new Position();
        assertThat(position.move()).isEqualTo(new Position(1));
    }

    @Test
    public void positionIllegalException() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
