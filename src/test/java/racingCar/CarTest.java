package racingCar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.domains.Car;
import racingCar.domains.FixedNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void numberIsLessThanFour(int input) {
        Car car = new Car("test", new FixedNumberGenerator(input));
        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8,9})
    void numberIsMoreThanFour(int input) {
        Car car = new Car("test", new FixedNumberGenerator(input));
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
