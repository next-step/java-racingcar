package race.domian;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    void 포지션_생성() {
        Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void 포지션_음수값_불가() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 포지션_이동() {
        Position position = new Position(0);
        position.move();
        Position positionInOne = new Position(1);
        assertThat(position).isEqualTo(positionInOne);
    }
}