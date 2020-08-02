package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step2.CommonConstant;
import step2.Operator;
import step2.StringCarculator;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCarculator stringCarculator;

    @BeforeEach
    void setUp() {
        stringCarculator = new StringCarculator();
    }

    @ParameterizedTest
    @DisplayName("문자열 계산기 구현")
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 * 5 / 2:5", "5 - 3 / 1:2"}, delimiter = ':')
    void stringCalculatorTest(String inputExpression, int expected) {
        int resultValue = stringCarculator.calculate(inputExpression);

        assertThat(resultValue).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("문자열 계산기 덧셈 계산")
    @CsvSource(value = {"1 + 2:3", "4 + 6:10", "5 + 4:9"}, delimiter = ':')
    void stringCalculatorAdditionTest(String inputExpression, int expected) {
        int resultValue = stringCarculator.calculate(inputExpression);

        assertThat(resultValue).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("문자열 계산기 곱셈 계산")
    @CsvSource(value = {"5 * 5:25", "7 * 1:7", "4 * 7:28"}, delimiter = ':')
    void stringCalculatorMultiplication(String inputExpression, int expected) {
        int resultValue = stringCarculator.calculate(inputExpression);

        assertThat(resultValue).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("문자열 계산기 나눗셈 계산")
    @CsvSource(value = {"5 / 5:1", "100 / 10:10", "44 / 2:22"}, delimiter = ':')
    void stringCalculatorDivisionTest(String inputExpression, int expected) {
        int resultValue = stringCarculator.calculate(inputExpression);

        assertThat(resultValue).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("문자열 계산기 뺄셈 계산")
    @CsvSource(value = {"5 - 4:1", "100 - 15:85", "7 - 7:0"}, delimiter = ':')
    void stringCalculatorSubtractionTest(String inputExpression, int expected) {
        int resultValue = stringCarculator.calculate(inputExpression);

        assertThat(resultValue).isEqualTo(expected);
    }


    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("공백 값 또는 null값이 입력될 경우 예외처리 테스트")
    void inValidInputExpressionTest1(String inputExpression) {
        assertThatThrownBy(() -> {
            StringCarculator.inputExpressionInValidException(inputExpression);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(CommonConstant.INVALID_INPUT_EXPRESSION);
    }

    @Test
    @DisplayName("사칙연산이 아닌 다른 기호가 입력될때의 예외처리 테스트")
    void inValidOperatorTest() {
        String expression = "&";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.operate(expression, 1, 2);
        }).withMessageMatching(expression + CommonConstant.INVALID_OPERATOR);

    }

    @Test
    @DisplayName("나눗셈 연산에서 0으로 나누 경우 발생하는 Exception 테스트")
    void divisionExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Operator.operate("/", 5, 0);
                }).withMessageMatching(CommonConstant.INVALID_DIVIDED_BY_ZERO);
    }

}
