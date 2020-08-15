package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void 자동차_객체_생성() {
        Car car = new Car();
        assertEquals(car.moveCar(false), 0);
    }
}
