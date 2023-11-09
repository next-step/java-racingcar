package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:4:0", "2:4:0", "4:4:1", "5:4:1"}, delimiter = ':')
    void move(int input, int decisionValue, int expected) {
        Car car = new Car("test", 0);
        car.move(input, decisionValue);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}