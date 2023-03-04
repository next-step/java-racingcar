package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
    public Calculator calculator;

    @BeforeEach
    void before() {
        calculator = new Calculator();
    }

    @DisplayName("계산식 정상 수행 테스트")
    @ParameterizedTest(name = "{displayName} [{index}]: ''{argumentsWithNames}''")
    @CsvSource( {"'2 + 3 * 4 / 2', 10.0", "'4 + 6 * 20', 200"})
    void calculateMathExpressionTest(String mathExpression, double expectedNumber) {
        double result = calculator.calculateMathExpression(mathExpression);
        Assertions.assertThat(result).isEqualTo(expectedNumber);
    }

    @DisplayName("공백 계산식 예외 발생 테스트")
    @ParameterizedTest(name = "{displayName} [{index}]: ''{argumentsWithNames}''")
    @ValueSource(strings = {" ", ""})
    void calculateBlankExcept(String mathExpression) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculateMathExpression(mathExpression))
                .withMessageMatching("empty String");
    }

    @DisplayName("연산자 테스트")
    @ParameterizedTest(name = "{displayName} [{index}]: ''{argumentsWithNames}''")
    @CsvSource({    "'+',2,3,5",
                    "'-',5,2,3",
                    "'/',6,2,3",
                    "'*',5,2,10"})
    void operatorTest(String operator, double numberA, double numberB, double expectedResult) {
        Assertions.assertThat(calculator.calculate(operator, numberA, numberB)).isEqualTo(expectedResult);
    }
}
