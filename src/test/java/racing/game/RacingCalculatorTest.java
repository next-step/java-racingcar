package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCalculatorTest {

    @Test
    void 랜덤값이_0_9사이() {
        RacingCalculator racingCalculator = new RacingCalculator();
        assertThat(racingCalculator.getRandomNumber()).isBetween(0, 9);

    }

}
