package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 값이 4 이상인 경우 이동 거리를 추가한다")
    void shouldCountIfGreaterThanFour(int randomNumber) {
        Car car = new Car();

        if (car.canMove(randomNumber)) {
            car.move();
        }

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 값이 4 미만인 경우 이동 거리를 추가하지 않는다")
    void shouldNotCountIfLessThanFour(int randomNumber) {
        Car car = new Car();

        if (car.canMove(randomNumber)) {
            car.move();
        }

        assertThat(car.getDistance()).isEqualTo(0);
    }
}