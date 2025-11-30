package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    @Test
    public void 포지션_이동() {
        Position position = new Position(0);
        position.move();

        assertThat(position).isEqualTo(new Position(1));
    }
}
