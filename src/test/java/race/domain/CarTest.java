package race.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import race.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:-","2:--","3:---"}, delimiter = ':')
    void go(int count, String expected) {
        assertThat(new Car().go(count)).isEqualTo(expected);
    }

}
