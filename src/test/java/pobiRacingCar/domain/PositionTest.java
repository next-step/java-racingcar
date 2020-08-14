package pobiRacingCar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void createPosition() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void movedTrue() {
        Position movedPosition = new Position(1).move();
        assertThat(movedPosition).isEqualTo(new Position(2));
    }
}
