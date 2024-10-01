package racing.car.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCalculatorTest {

    @Test
    void 랜덤값이_0_9사이() {
        assertThat(RacingCalculator.getRandomNumber()).isBetween(0,9);
    }

}
