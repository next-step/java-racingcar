package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1:2:3","2:5:7"},delimiter = ':')
    @DisplayName("더하기 테스트")
    void plusTest(int a, int b,int result) {
        Operator operator = Operator.PLUS;
        assertThat(operator.apply(a,b)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:-1","5:3:2"},delimiter = ':')
    @DisplayName("빼기 테스트")
    void subtractionTest(int a, int b, int result) {
        Operator operator = Operator.SUB;
        assertThat(operator.apply(a,b)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:3:2","8:1:8"},delimiter = ':')
    @DisplayName("나누기 테스트")
    void divisionTest(int a, int b, int result) {
        Operator operator = Operator.DIV;
        assertThat(operator.apply(a,b)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:6:12","3:3:9"},delimiter = ':')
    @DisplayName("곱하기 테스트")
    void multiplicationTest(int a,int b,int result) {
        Operator operator = Operator.MUL;
        assertThat(operator.apply(a,b)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","   "})
    @DisplayName("문자열 공백 테스트")
    void IsEmptyByFormulaTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                   Calculator calculator = new Calculator();
                   calculator.calculate(input);
                }).withMessage("문자열이 공백입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"#","$","!","&"})
    @DisplayName("잘못된 사칙연산 기호 테스트")
    void wrongOperatorTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                   Operator operator = Operator.getOperator(input);
                }).withMessage("사칙연산 기호가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"3 + 5 : 8","3 * 4 : 12","4 / 4 : 1","1 - 2 : -1","2 + 3 * 4 / 2 : 10"},delimiter = ':')
    @DisplayName("문자열 계산기 테스트")
    void stringCalculateTest(String formula, int result) {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(formula)).isEqualTo(result);
    }
}
