package cargameracing;

import cargameracing.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void move() {
        Position source = new Position(1);
        Position target = new Position(2);
        assertThat(source.move()).isEqualTo(target);
    }

    @Test
    void valid() {
        assertThat(new Position(4)).isEqualTo(new Position(4));
    }
}
