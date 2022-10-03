package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final Car car = new Car();

    @ParameterizedTest
    @DisplayName("랜덤 값이 4이상인 경우 자동차는 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void go_forward_car_value_more_than_4(int randomValue) {
        Car movedCar = car.move(new ManualValueGenerator(randomValue));
        assertThat(movedCar.getLocation()).isEqualTo(car.getLocation() + 1);
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 4보다 작은 경우 자동차는 멈춘다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void stop_car_value_smaller_than_4(int randomValue) {
        Car movedCar = car.move(new ManualValueGenerator(randomValue));
        assertThat(movedCar.getLocation()).isEqualTo(car.getLocation());
    }
}
