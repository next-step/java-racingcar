package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0 = 0", "1 = 0", "3 = 0", "4 = 1", "8 = 1", "9 = 1"}, delimiter = '=')
    void go(int power, int expect) {
        Car car = new Car();
        car.go(power);
        assertThat(car.getCurrentPosition()).isEqualTo(expect);
    }
}