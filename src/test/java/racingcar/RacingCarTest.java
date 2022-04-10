package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void randomIsOverThan3Given_ShouldMove() {
        assertThat(RacingCar.move(4)).isEqualTo(1);
    }

    @Test
    void randomIsUnderThan4Given_ShouldStay() {
        assertThat(RacingCar.move(3)).isEqualTo(0);
    }
}
