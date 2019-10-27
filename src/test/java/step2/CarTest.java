package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static Car car = new Car();

    @ParameterizedTest
    @CsvSource(value = {"true:1", "true:2", "false:2", "true:3"}, delimiter = ':')
    void go(boolean is, int count) {
        car.ahead(is);
        assertThat(car.score).isEqualTo(count);
    }
}