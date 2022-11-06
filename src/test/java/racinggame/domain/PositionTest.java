package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void 기본_위치() {
        assertThat(new Position().getPosition()).isEqualTo(0);
    }

    @Test
    void 이동() {
        Position position = new Position();
        position.increase();
        assertThat(position).isEqualTo(new Position(1));
    }
}
