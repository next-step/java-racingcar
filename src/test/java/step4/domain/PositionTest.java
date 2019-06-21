package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void 기본_위치는_0이다() {
        Position position = new Position();
        assertThat(position).isEqualTo(0);
    }
}