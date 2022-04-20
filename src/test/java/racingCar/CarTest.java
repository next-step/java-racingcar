package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("랜덤값이 4 미만인 경우 전진할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void RandomNumberIsLessThanFour(int input) {
        Car car = new Car(new FixedIntegerGenerator(input));
        car.tryMove();

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("랜덤값이 4 이상인 경우 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void RandomNumberIsMoreThanFour() {
        Car car = new Car(new FixedIntegerGenerator(4));
        car.tryMove();

        assertThat(car.getDistance()).isEqualTo(1);
    }

}
