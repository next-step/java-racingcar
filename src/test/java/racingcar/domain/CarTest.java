package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤 값이 4이상인 경우 자동차는 전진한다.")
    void go_forward_car_value_more_than_4() {
        ManualValueGenerator generator = new ManualValueGenerator(4, 5, 6, 7, 8, 9);
        Car car = new Car();
        while (generator.hasNext()) {
            int before = car.getLocation();
            car.nextTurn(generator);
            assertThat(car.getLocation()).isEqualTo(before + 1);
        }
    }

    @Test
    @DisplayName("랜덤 값이 4보다 작은 경우 자동차는 멈춘다.")
    void stop_car_value_smaller_than_4() {
        ManualValueGenerator generator = new ManualValueGenerator(0, 1, 2, 3);
        Car car = new Car();
        while (generator.hasNext()) {
            int before = car.getLocation();
            car.nextTurn(generator);
            assertThat(car.getLocation()).isEqualTo(before);
        }
    }
}
