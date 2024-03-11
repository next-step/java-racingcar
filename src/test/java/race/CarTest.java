package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:-","2:--","3:---"}, delimiter = ':')
    void go(int input, String expected) {
        assertThat(new Car(1).go(input)).isEqualTo(expected);
    }
}
