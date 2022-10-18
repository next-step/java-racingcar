package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.model.RacingCar;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    @Test
    @DisplayName("Race Test")
    public void race() {

        RacingCar racingCar = RacingCar.createWithDistance(2);
        racingCar.race();

        assertTrue(racingCar.distance() == 2 || racingCar.distance() == 3);
    }
}
