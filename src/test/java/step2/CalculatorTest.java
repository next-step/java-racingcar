package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.DefaultArgumentConverter;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("계산기 TEST")
public class CalculatorTest {

    @DisplayName("계산식 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void string_calculation_convert_success(String input) {
        assertThat(Calculator.ofFormula(input))
            .containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @DisplayName("계산식 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"null", "  ", "2 + 3 * 4 / 2!@", "!2 + 3 * 4 / 2!@"})
    public void string_calculation_convert_fail_illegalArgumentException(@ConvertWith(NullableConverter.class) String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.ofFormula(input));
    }

    @DisplayName("문자열 사칙연산 성공")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void string_calculation_success(String input) {
        Calculator calculator = new Calculator(input);
        assertThat(calculator.getOperationResult()).isEqualTo(10);
    }

    @DisplayName("문자열 사칙연산 실패 -> 0으로 나눔")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 0"})
    public void string_calculation_fail_arithmeticException(String input) {
        Calculator calculator = new Calculator(input);
        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(calculator::getOperationResult)
            .hasToString("java.lang.ArithmeticException: BigInteger divide by zero");
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