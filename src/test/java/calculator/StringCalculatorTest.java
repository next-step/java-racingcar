package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private Calculator calculator = new StringCalculator();

    @ParameterizedTest
    @CsvSource(value = {"1 * 2 + 3 / 4 - 1:0.25", "10 * 3 / 2 + 5 - 3:17"}, delimiter = ':')
    @DisplayName("StringCalculator 계산 테스트")
    public void calculateTest(String arg, double expected){
        assertThat(calculator.calculate(arg)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1 * 2 + 3", "1 ! 2"})
    @DisplayName("StringCalculator 계산 예외 테스트")
    public void illegalArgumentTest(String arg){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 * 2 - 1 / 0 + 3"})
    @DisplayName("0으로 나누기 테스트")
    public void divisionWithZeroTest(String arg){
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.calculate(arg));
    }
}
