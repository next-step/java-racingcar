package domain;

import movingStrategy.AlwaysMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest {
  
    public static final String NAME = "test";

    @DisplayName("차량 위치 확인 테스트")
    @Test
    void position() {
        RacingCar racingCar = new RacingCar(NAME, new AlwaysMove());
        assertEquals(0, racingCar.position());
    }

    @DisplayName("차량 진행 테스트")
    @Test
    void tryToGo() {
        RacingCar racingCar = new RacingCar(NAME, new AlwaysMove());
        racingCar.move();
        assertEquals(1, racingCar.position());
    }
    
    @DisplayName("차량 이름 확인 테스트")
    @Test
    void name() {
        RacingCar racingCar = new RacingCar(NAME, new AlwaysMove());
        assertEquals(NAME, racingCar.name());
    }
}