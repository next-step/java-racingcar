package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> new Car("name"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("움직일 수 있다.")
    void moveRangeCheckSuccess(int number) {
        Car car = new Car("name");
        car.move(true);
        assertEquals(car.getDistance().getValue(), 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 1, 2, 3, 10, 100})
    @DisplayName("움직일 수 없다.")
    void moveRangeCheckFail(int number) {
        Car car = new Car("name");
        car.move(false);
        assertEquals(car.getDistance().getValue(), 0);
    }
}
