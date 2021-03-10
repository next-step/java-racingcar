package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @DisplayName("수식 계산, 지원하지 않는 사칙연산")
    @ParameterizedTest
    @CsvSource(value = "10:^:7", delimiter = ':')
    void unsupportOperatorCheck(int num1, String operator, int num2) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.execute(num1, operator, num2);
        }).withMessage(CalculatorError.UNSUPPORTED_OPERATOR);
    }

    @DisplayName("수식 계산, 나눗셈의 나머지가 0이 아닐 경우")
    @ParameterizedTest
    @CsvSource(value = "10:/:7", delimiter = ':')
    void divideResultIsNotInteger(int num1, String operator, int num2) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.execute(num1, operator, num2);
        }).withMessage(CalculatorError.DIVIDE_RESULT_MUST_INTEGER);
    }

    @DisplayName("수식 계산, 성공")
    @ParameterizedTest
    @CsvSource(value = {"10:+:5:15", "10:-:5:5", "10:*:5:50", "10:/:5:2"}, delimiter = ':')
    void execute(int num1, String operator, int num2, int expect) {
        assertThat(Operator.execute(num1, operator, num2)).isEqualTo(expect);
    }
}