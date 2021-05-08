import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    void test() {
        RacingCar racingCar = new RacingCar();
        String carNames = "pobi,woni,jun";
        int roundNumber = 3;

        assertThat(racingCar.makeResult(carNames, roundNumber).matches(carNames));
    }
}
