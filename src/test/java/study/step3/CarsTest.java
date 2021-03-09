package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("차량 3대 등록")
    @ParameterizedTest
    @CsvSource(value = {"3:3"}, delimiter = ':')
    void of(int carNumber, int expected) {
        Cars cars = Cars.of(carNumber);
        assertThat(cars.getCarSize()).isEqualTo(expected);
    }
}
