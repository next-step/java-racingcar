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
}