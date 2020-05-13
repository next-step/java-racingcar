package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차는 4 이상인 값이 들어왔을때 움직인다.")
    @ParameterizedTest
    @CsvSource({"5,1", "4,1", "7,1"})
    void move(int randomNumber, int location) {
        Car car = new Car();

        int actualLocation = car.move(randomNumber);

        assertThat(actualLocation).isEqualTo(location);
    }

    @DisplayName("자동차는 4 미만이 값이 들어오면 움직이지 않는다.")
    @ParameterizedTest
    @CsvSource({"0, 0", "1, 0", "2, 0", "3, 0"})
    void doNotMove(int randomNumber, int location) {
        Car car = new Car();

        int actualLocation = car.move(randomNumber);

        assertThat(actualLocation).isEqualTo(location);
    }
}
