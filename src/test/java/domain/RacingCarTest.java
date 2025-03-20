package domain;

import movingStrategy.AlwaysMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest {

    @DisplayName("차량 위치 확인 메소드 테스트")
    @Test
    void whereIsCar() {
        RacingCar racingCar = new RacingCar(new AlwaysMove());
        assertEquals(0, racingCar.whereIsCar());
    }

    @DisplayName("차량 진행 메소드 테스트")
    @Test
    void tryToGo() {
        RacingCar racingCar = new RacingCar(new AlwaysMove());
        racingCar.move();
        assertEquals(1, racingCar.whereIsCar());
    }
}