package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("4이상 9이하이면 1만큼 이동한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_plusOne(Integer randomNumber) {
        Car car = Car.of(0, "");

        assertThat(car.move(randomNumber)).isEqualTo(Car.of(1, ""));
    }

    @DisplayName("0이상 3이하이면 0만큼 이동한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void move(Integer randomNumber) {
        Car car = Car.of(0, "");

        assertThat(car.move(randomNumber)).isEqualTo(Car.of(0, ""));
    }
}