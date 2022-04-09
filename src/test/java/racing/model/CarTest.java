package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("전략에 따라 자동차 전진 또는 멈춤")
    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"}, delimiter = ',')
    void carMoveForward(@ConvertWith(BooleanConverter.class) Boolean isMovable, int expected) {
        CarMoveStrategy carMoveStrategy = () -> isMovable;
        Car car = new Car(carMoveStrategy);
        assertThat(car.run()).isEqualTo(expected);
    }

    private static class BooleanConverter implements ArgumentConverter {
        @Override
        public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
            if (!(source instanceof String)) {
                throw new IllegalArgumentException("The argument should be a String: " + source);
            }
            try {
                return Boolean.parseBoolean((String) source);
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to convert", e);
            }
        }
    }
}