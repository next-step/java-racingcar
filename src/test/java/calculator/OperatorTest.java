package calculator;

import static calculator.Operand.ZERO;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @DisplayName("Symbol 에 맞는 Operator 를 찾는지 확인 하는 테스트")
    @ParameterizedTest
    @ValueSource(strings ={"+", "-", "*", "/"})
    void findRightOperator(final String symbol) {
        Operator operator = Operator.findOperator(symbol);
        assertThat(symbol).isIn(operator.getSymbol());
    }

    @DisplayName("연산자와 피연산자를 받아 Operate 메소드를 수행하는 테스트")
    @ParameterizedTest
    @MethodSource("operations")
    void validateOperate (final Operand leftOperand, final Operator operator, final Operand rightOperand, final Operand expected) {
        assertThat(operator.operate(leftOperand, rightOperand)).isEqualTo(expected);
    }

    static Stream<Arguments> operations() {
        return Stream.of(
            Arguments.of(Operand.of(2), Operator.PLUS, Operand.of(3), Operand.of(5)),
            Arguments.of(Operand.of(-42), Operator.MINUS, Operand.of(15), Operand.of(-57)),
            Arguments.of(Operand.of(7), Operator.MULTIPLY, Operand.of(-9), Operand.of(-63)),
            Arguments.of(Operand.of(42), Operator.DIVIDE, Operand.of(2), Operand.of(21))
        );
    }


        assertThatThrownBy(() -> operator.operate(Operand.of(value), ZERO))
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