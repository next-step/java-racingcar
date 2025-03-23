package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void position_move() {
        Position position = new Position(0);
        position = position.move();
        assertThat(position.currentPosition()).isEqualTo(1);
    }

}
