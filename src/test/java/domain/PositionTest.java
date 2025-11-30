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

    @Test
    public void 포지현_문자열_출력() {
        Position position = new Position(5);
        assertThat(position.toString()).isEqualTo("-".repeat(5));
    }

    @Test
    public void 최대값() {
        assertThat(new Position(1).max(new Position(2))).isEqualTo(new Position(2));
    }
}
