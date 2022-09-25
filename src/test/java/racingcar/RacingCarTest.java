package racingcar;

import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void racing_정상_진행() {
        RacingCar racingCar = new RacingCar(3, 5);
        racingCar.racingStart();
    }
}