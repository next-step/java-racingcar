package racing.util.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.Cars;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsConverterTest {
    @DisplayName("convert Test")
    @ValueSource(strings = {
            "A,B,C,D",
            "AA,BB,C"
    })
    @ParameterizedTest
    public void convertTest(String strCarNames) {
        int expertSize = strCarNames.split(",").length;

        Cars cars = CarsConverter.getInstance().convert(strCarNames);

        assertThat(cars.size())
                .isEqualTo(expertSize);
    }

    @DisplayName("convert InvalidInputException Test")
    @ValueSource(strings = {
            "",
            "   "
    })
    @ParameterizedTest
    public void convertInvalidInputExceptionTest(String strCarNames) {
        assertThatThrownBy(() -> convertTest(strCarNames))
                .isInstanceOf(InvalidInputException.class);
    }
}