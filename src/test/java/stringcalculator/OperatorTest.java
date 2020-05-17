package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {
    @DisplayName("사칙 연산 기호일 경우 올바른 Operator 객체를 얻어냄")
    @ParameterizedTest
    @CsvSource({"+,ADDITION", "-,SUBTRACTION", "*,MULTIPLICATION", "/,DIVISION"})
    void validOperators(String mark, Operator operator) {
        assertThat(Operator.from(mark)).isEqualTo(operator);
    }

    @DisplayName("사칙 연산 기호가 아닐 경우 에러를 던짐")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "&"})
    void isNotValidOperatorShouldThrowIllegalArgumentException(String wrongOperator) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.from(wrongOperator);
        }).withMessage(Operator.getErrorMessage(wrongOperator));
    }

    @DisplayName("덧셈, 뺄셈, 곱셈, 나눗셈")
    @ParameterizedTest
    @CsvSource({"ADDITION,11,3,14", "SUBTRACTION,2,10,-8", "MULTIPLICATION,3,6,18", "DIVISION,15,5,3"})
    void operations(Operator operator, int a, int b, int expected) {
        assertThat(operator.operate(a, b)).isEqualTo(expected);
    }
}
