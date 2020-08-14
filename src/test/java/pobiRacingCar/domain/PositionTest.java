package pobiRacingCar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void createPosition() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }
}
