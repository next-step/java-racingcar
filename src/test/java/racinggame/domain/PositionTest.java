package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void 생성() {
        assertThat(new Position(4)).isEqualTo(new Position(4));
    }

    @Test
    void 최대값_구하기() {
        Position position = new Position(4);
        assertThat(position.max(3)).isEqualTo(4);
        assertThat(position.max(5)).isEqualTo(5);
    }
}
