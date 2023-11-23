package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingCar.domain.Car;
import racingCar.domain.Distance;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @DisplayName("random한 수가 4 이상이면 전진한다.")
    @CsvSource(value = { "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1" }, delimiter = ':')
    void test1(int randomNumber, int expecting) {
        Car car = new Car(0);
        Distance expectingResult = new Distance(expecting);

        assertThat(car.moveForward(randomNumber)).isEqualTo(expectingResult);
    }
}
