import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.domain.GameCondition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void advance(boolean expected, int result) {
        GameCondition condition = () -> expected;

        Car car = new Car("test");
        car.advance(condition);
        assertThat(car.getNumberOfAdvance())
                .isEqualTo(result);
    }

    @Test
    void validationName(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car("test1234");
                });
    }
}
