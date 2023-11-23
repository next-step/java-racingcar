package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @DisplayName("4이상일때 차가 한 칸 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    void isCarMoveable(int input, int expectedIdx) {
        Car car = new Car();
        car.moveForward(input);
        assertThat(car.getPosition().getPosition()).isEqualTo(expectedIdx);
    }
}
