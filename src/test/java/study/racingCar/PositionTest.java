package study.racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void increaseTest() {
        Position position = new Position();
        assertThat(position.increase(4)).isEqualTo(new Position(1));
    }
}