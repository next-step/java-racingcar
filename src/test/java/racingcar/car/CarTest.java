package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 정지")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void hold(int input) {
        Car car = new Car();
        int prevPosition = car.getPosition();

        car.move(input);
        assertThat(car.getPosition()).isEqualTo(prevPosition);
    }

    @DisplayName("자동차 이동")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9,10})
    void move(int input) {
        Car car = new Car();
        int prevPosition = car.getPosition();

        car.move(input);
        assertThat(car.getPosition()).isGreaterThan(prevPosition);
    }
}