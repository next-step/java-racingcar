package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.car.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @DisplayName("이동 성공")
    void test_move_success() {
        // Given
        Car car = new Car();

        // When
        car.move(new NewEngine());

        // Then
        assertEquals(car.getCurrentPosition(), 2);
    }

    @Test
    @DisplayName("이동 실패")
    void test_move_fail() {
    // Given
        Car car = new Car();

        // When
        car.move(new BrokenEngine());

        // Then
        assertEquals(car.getCurrentPosition(), 1);
    }

}