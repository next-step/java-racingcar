package setp2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.DefaultArgumentConverter;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static setp2.Calculator.hasNumeric;
import static setp2.Calculator.hasOperator;

public class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void ofFormula(String input) {
        assertThat(Calculator.ofFormula(input))
            .containsExactly("2","+","3","*","4","/","2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"null", "  ", "2 + 3 * 4 / 2!@", "!2 + 3 * 4 / 2!@"})
    public void shouldIllegalArgumentExceptionOfFormula(@ConvertWith(NullableConverter.class)String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.ofFormula(input);
        });
    }
}

final class NullableConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if ("null".equals(source)) {
            return null;
        }
        return DefaultArgumentConverter.INSTANCE.convert(source, targetType);
    }
}