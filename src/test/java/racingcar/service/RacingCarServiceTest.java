package racingcar.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingCarServiceTest {
    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    public void generateRandomNumberForMovingCarTest() {
        int[] randomNumbers = racingCarService.generateRandomNumberForMovingCar(3);

        for(int carNumber : randomNumbers) {
            assertThat(carNumber).isBetween(1, 9);
        }
    }
}
