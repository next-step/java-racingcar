package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void 기본_위치() {
        assertThat(new Position().getPosition()).isEqualTo(0);
    }

    @Test
    void moveTest() {
        Position position = new Position();
        position.move();
        assertThat(position).isEqualTo(new Position(1));
    }
}