package teacher.step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void invalid() {
        assertThatThrownBy(()-> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(1); // position.getPosition() 에서 position.isSamePosition() 에서
    }
}
