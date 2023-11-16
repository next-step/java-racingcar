package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @DisplayName("값이 4이상의 경우 최초 position 0 에서 1 증가 한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void test_MoveCar(int value) {
        Car car = new Car();
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("값이 4미만의 경우 최초 position 0이 변경 되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void test_StopCar(int value) {
        Car car = new Car();
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("값이 음수인 경우 예외가 발생한다.")
    @Test
    void test_CarMovementError() {
        Car car = new Car();
        assertThrows(IllegalArgumentException.class, () -> car.move(-1));
    }
}
