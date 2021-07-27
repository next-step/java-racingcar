package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> new Car("name"));
    }

    @Test
    @DisplayName("움직일 수 있다.")
    void moveRangeCheckSuccess() {
        Car car = new Car("name");
        car.move(true);
        assertEquals(car.getDistance().getValue(), 1);
    }

    @Test
    @DisplayName("움직일 수 없다.")
    void moveRangeCheckFail() {
        Car car = new Car("name");
        car.move(false);
        assertEquals(car.getDistance().getValue(), 0);
    }
}
