import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    void advance(int input, int result) {
        GameCondition condition = () -> input;

        Car car = new Car();
        car.advance(condition);
        assertThat(car.getNumberOfAdvance())
                .isEqualTo(result);
    }
}
