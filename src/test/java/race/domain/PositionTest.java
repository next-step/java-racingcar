package race.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void positionTest() {
        assertThat(new Position(5)).isEqualTo(new Position(5));
    }

}
