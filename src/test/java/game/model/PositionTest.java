package game.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 포지션_이동() {
        Position position = new Position(0);

        position.increase();

        Assertions.assertThat(position).isEqualTo(new Position(1));
    }

}
