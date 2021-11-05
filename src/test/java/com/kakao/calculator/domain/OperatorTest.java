package com.kakao.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @Test
    @DisplayName("문자열을 받으면 해당하는 연산자 타입을 반환한다")
    void getValue() {
        Operator plus = Operator.of("+");
        assertThat(plus).isEqualTo(Operator.PLUS);
    }

    @ParameterizedTest
    @DisplayName("Operator에 해당하는 연산을 수행한다.")
    @MethodSource("operatorTestParameters")
    void operatorExecute(Operator operator, double expected) {
        Operand operand1 = new Operand(6.0);
        Operand operand2 = new Operand(2.0);

        Operand result = operator.operation(operand1, operand2);

        assertThat(result.getValue()).isEqualTo(expected);
    }

    private static Stream<Arguments> operatorTestParameters() {
        return Stream.of(
                Arguments.arguments(Operator.PLUS, 8.0),
                Arguments.arguments(Operator.MINUS, 4.0),
                Arguments.arguments(Operator.MULTIPLE, 12.0),
                Arguments.arguments(Operator.DIVIDE, 3.0)
        );
    }

    @Test
    @DisplayName("나누기를 했을 때 0으로 나누면 에러를 발생시킨다")
    void divideException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.DIVIDE.operation(new Operand(2.0), new Operand(0.0)));
    }

    @Test
    @DisplayName("문자열을 받았을 때 알맞은 연산자 타입이 아니면 에러를 발생시킨다")
    void getValueException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of("="));
    }

}
