package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final Car car = new Car(new Name("A"));

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
    @DisplayName("자동차 A의 위치가 B보다 크다.")
    void bigger_than_true() {
        Car carA = new Car(new Name("A"), new Location(2));
        Car carB = new Car(new Name("B"), new Location(1));
        assertThat(carA.isFar(carB)).isTrue();
    }

    @Test
    @DisplayName("자동차 B의 위치가 A보다 크다.")
    void bigger_than_false() {
        Car carA = new Car(new Name("A"), new Location(0));
        Car carB = new Car(new Name("B"), new Location(1));
        assertThat(carA.isFar(carB)).isFalse();
    }

    @Test
    @DisplayName("자동차 A와 B의 위치가 같으면 동일선 상에 있다.")
    void is_same_location() {
        Car carA = new Car(new Name("A"), new Location(1));
        Car carB = new Car(new Name("B"), new Location(1));
        assertThat(carA.findCollinearName(carB)).isEqualTo(new Name("A"));
    }
}
