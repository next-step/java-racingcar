package step3.car_racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @DisplayName("moveForward 메서드 실행 시 거리 만큼 전진 한다.")
    void moveForward() {
        // given
        Car car = new Car();

        // expected
        assertEquals(car.getDistance() + 1, car.moveForward());
    }
}