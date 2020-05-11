package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    private static final String DIVIDE = "/";
    private static final String ZERO = "0";

    @DisplayName("나누기 연산일 때, 오른쪽 피연산자가 0이면 0으로 나누었을 때, throw IllegalArgumentException 를 실행")
    @ParameterizedTest
    @ValueSource(strings = {"1", "4", "77"})
    void throwExceptionIfDivideByZero (final String value) {
        Operator operator = Operator.findOperator(DIVIDE);
        assertThatThrownBy(() -> operator.operate(Operand.of(value), Operand.of(ZERO)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @DisplayName("사칙연산 기호가 아닌 값이 들어갔을 때, throw IllegalArgumentException 를 실행")
    @ParameterizedTest
    @ValueSource(strings = {"!", "&", "$", "#"})
    void throwExceptionIfWrongOperator(final String symbol) {
        assertThatThrownBy(() -> Operator.findOperator(symbol))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("잘못된 기호입니다. 사칙 연산 기호을 입력해주세요. " + symbol);
    }

    @DisplayName("연산자가 Null 또는 공백 문자일 때, throw IllegalArgumentException 를 실행")
    @ParameterizedTest
    @NullAndEmptySource
    void throwExceptionIfNullAndEmptyValue(final String symbol) {
        assertThatThrownBy(() -> Operator.findOperator(symbol))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Null 또는 공백 문자는 연산자가 될 수 없습니다.");
    }
}