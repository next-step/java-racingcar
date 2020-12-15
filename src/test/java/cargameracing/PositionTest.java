package cargameracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void move() {
        Position source = new Position(1);
        Position target = new Position(2);
        //assertThat(target).isEqualTo(source.move());
    }

    @Test
    void valid() {
        assertThat(new Position(4)).isEqualTo(new Position(4));
    }
}
