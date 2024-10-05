package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRandomCalculatorTest {

    @Test
    void 랜덤값이_0_9사이() {
        RacingRandomCalculator racingRandomCalculator = new RacingRandomCalculator();
        assertThat(racingRandomCalculator.getRandomNumber()).isBetween(0, 9);

    }

}
