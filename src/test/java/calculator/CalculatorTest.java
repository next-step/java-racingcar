package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    Calculator calculator;
    Operator operator;

    @DisplayName("사칙연산을 사용하여 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 3:9" , "2 + 4 / 2:3" , "5 + 5 - 1:9"}, delimiter = ':')
    public void calculator(String input , int result) {
        //GIVE

        //WHEN
        int num = calculator.calculate(input);
        //THEN
        assertThat(num).isEqualTo(result);
    }

    @DisplayName("전체값을 0으로 나눴을 때 IllegalArgumentException Exception 발생")
    @Test
    public void validateCalculatorToZero() {
        //GIVE

        //WHEN

        //THEN
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Operator.calculation("/",20,0));
    }

    @DisplayName("사칙연산 값 테스트, 사칙연산과 다른 값이 들어가면 IllegalArgumentException Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"%"})
    void validateInputSize(String input) {
        //GIVE

        //WHEN

        //THEN
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Operator.converterOperator(input));
    }

    @BeforeEach
    void createInstance() {
        calculator = new Calculator();
    }
}
