package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    @Test
    void test() {
        RacingCar racingCar = new RacingCar(3, 5);
        racingCar.racingStart();
    }
}