package study;

import CarRacing.Car;
import CarRacing.Cars;
import CarRacing.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class CarRacingTest {


    @Test
    @DisplayName("포지션 출력테스트")
    void positionRandom() {
        Position position = new Position();
        position.move();
        assertTrue(position.getPosition() == 1 || position.getPosition() == 0);

    }

    @Test
    @DisplayName("자동차 대수 exceptionTest")
    void carCountException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cars(0));
        String message = exception.getMessage();
        assertEquals("자동차 개수는 0이하의 수를 허용하지 않습니다.", message);

    }

    @Test
    @DisplayName("자동차 대수 입력받고 자동차 move 테스트.")
    void insertCarAndGetCarCount() {
        Cars cars = new Cars(5);
        cars.moveAll();
        cars.getCars().forEach(s -> assertTrue(s.getPositon() == 1 || s.getPositon() == 0));
    }


}

