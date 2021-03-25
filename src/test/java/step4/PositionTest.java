package step4;

import org.junit.jupiter.api.Test;
import step4.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void create() {
        int init = 5;
        Position position = new Position(init);
        assertThat(position).isEqualTo(new Position(init));
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        int init = 5;
        Position position = new Position(init);
        assertThat(position.move()).isEqualTo(new Position(init + 1));
    }
}
