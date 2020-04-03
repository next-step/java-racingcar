package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("4 이상일때만 position + 1")
    @ParameterizedTest
    @CsvSource({"4, 1", "3, 0", "2, 0", "5, 1"})
    void moveIfPossible(int condition, int position) {
        Car car = new Car(new RacingCarMovableStrategy());
        assertThat(car.moveIfPossible(condition)).isEqualTo(position);
    }

    // TODO
    @DisplayName("항상 position + 1")
    @ParameterizedTest
    @CsvSource({"4, 1", "3, 1", "2, 1", "5, 1"})
    void moveAlways(int condition, int position) {
        Car car = new Car(value -> true);
        assertThat(car.moveIfPossible(condition)).isEqualTo(position);
    }

    @DisplayName("항상 position 그대로")
    @ParameterizedTest
    @CsvSource({"4, 0", "3, 0", "2, 0", "5, 0"})
    void notMove(int condition, int position) {
        Car car = new Car(value -> false);
        assertThat(car.moveIfPossible(condition)).isEqualTo(position);
    }
}