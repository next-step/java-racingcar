package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.ManualValueGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final Car car = new Car("A");

    @ParameterizedTest
    @DisplayName("랜덤 값이 4이상인 경우 자동차는 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void go_forward_car_value_more_than_4(int randomValue) {
        car.move(new ManualValueGenerator(randomValue));
        assertThat(car.getLocation()).isEqualTo(new Location(1));
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 4보다 작은 경우 자동차는 멈춘다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void stop_car_value_smaller_than_4(int randomValue) {
        car.move(new ManualValueGenerator(randomValue));
        assertThat(car.getLocation()).isEqualTo(new Location(0));
    }

    @Test
    @DisplayName("자동차 위치와 비교해서 더 멀리 있는 위치를 반환 한다.")
    void return_bigger_location() {
        Car carA = new Car("A", 2);
        assertThat(carA.findFar(new Location(1))).isEqualTo(new Location(2));
    }

    @Test
    @DisplayName("위치가 같으면 자동차 이름을 반환 한다.")
    void is_same_location() {
        Car carA = new Car("A", 1);
        assertThat(carA.findCollinearName(new Location(1))).isEqualTo(new Name("A"));
    }
}
