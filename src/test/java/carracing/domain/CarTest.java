package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    @DisplayName("random 값이 4이상일 경우 자동차가 1칸 전진한다.")
    void moveCar(int randomValue) {
        Car car = new Car();

        car.move(randomValue);

        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("random 값이 4미만일 경우 자동차는 움직이지 않는다.")
    void dontMoveCar(int randomValue) {
        Car car = new Car();

        car.move(randomValue);

        int position = car.getPosition();

        assertThat(position).isEqualTo(0);
    }
}