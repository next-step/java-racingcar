package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @CsvSource({"3,0", "4,1"})
    @DisplayName("move_결과 0,1의 경계값 입력_0,1")
    void move(int input, int expected) {
        Car car = new Car();
        car.move(input);
        assertThat(car.distance).isEqualTo(expected);
    }
}
