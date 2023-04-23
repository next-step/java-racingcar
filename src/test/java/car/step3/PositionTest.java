package car.step3;

import car.step3.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class PositionTest {

    @Test
    void create() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
