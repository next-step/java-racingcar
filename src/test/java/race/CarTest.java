package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---"}, delimiter = ':')
    void car__forward(int input, String expected) {
        Car car = new Car();
        assertThat(car.goForward(input)).isEqualTo(expected);
    }

}
