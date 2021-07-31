package study;

import CarRacing.Car;
import CarRacing.Cars;
import CarRacing.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class CarRacingTest {


    @Test
    @DisplayName("포지션 예외처리 테스트")
    void positionException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Position());
        String message = exception.getMessage();
        assertEquals("posision은 음수 값을 가질 수 없습니다.", message);

    }

    @Test
    @DisplayName("포지션 4이상일때 포지션값증가")
    void positionFourOverValue() {
        Position position = new Position();
        position.increasePosition(4);
        assertTrue(position.getPosition() == 1);

    }

    @Test
    @DisplayName("포지션 4미만일때 포지션값증가")
    void positionFourUnderValue() {
        Position position = new Position();
        position.increasePosition(3);
        assertTrue(position.getPosition() == 0);

    }

    @Test
    @DisplayName("자동차 대수 exceptionTest")
    void carCountException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cars(0));
        String message = exception.getMessage();
        assertEquals("자동차 개수는 0이하의 수를 허용하지 않습니다.", message);

    }
}

