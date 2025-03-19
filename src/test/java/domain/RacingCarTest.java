package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @DisplayName("차량 위치 확인 메소드 테스트")
    @Test
    void whereIsCar() {
        RacingCar racingCar = new RacingCar();
        assertEquals(0, racingCar.whereIsCar());
    }

    @DisplayName("차량 진행 메소드 테스트")
    @Test
    void tryToGo() {
        RacingCar racingCar = new RacingCar();
        racingCar.tryToGo(10);
        assertEquals(10, racingCar.whereIsCar());
    }
}