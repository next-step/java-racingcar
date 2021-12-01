package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void move() {
        Position position = new Position(3);
        position.move();
        assertThat(position).isEqualTo(new Position(4));
    }

    public static Position p(int position) {
        return new Position(position);
    }
}
