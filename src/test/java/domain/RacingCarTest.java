package domain;

import movingStrategy.AlwaysMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest {
  
    public static final String NAME = "test";

    @DisplayName("차량 진행 테스트")
    @Test
    void tryToGo() {
        RacingCar racingCar = new RacingCar(NAME, 0);
        racingCar.move(new AlwaysMove());
        assertEquals(new RacingCar(NAME, 1), racingCar);
    }
}