package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void randomIsOverThan3Given_ShouldMove() {
        assertThat(new RacingCar().move(4)).isEqualTo(1);
    }

    @Test
    void randomIsUnderThan4Given_ShouldStay() {
        assertThat(new RacingCar().move(3)).isEqualTo(0);
    }

    @Test
    void randomIsOverThan3TwiceGiven_ShouldMoveTwice() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(4);
        assertThat(racingCar.move(4)).isEqualTo(2);
    }
}
