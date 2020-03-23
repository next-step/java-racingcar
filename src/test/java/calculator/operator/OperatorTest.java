package calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperatorTest {

    @DisplayName("사칙연산자 체크를 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperator(String operator) {
        // when
        final boolean actual = Operator.isOperator(operator);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("사칙연산자가 아닐 경우 예외를 발생한다.")
    @Test
    void wrongOperator() {
        // given
        final String wrongOperatorText = "&";

        // when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> { Operator.getOperator(wrongOperatorText); }
        );
    }

    @DisplayName("사칙 연산자를 성공적으로 반환한다.")
    @ParameterizedTest
    @MethodSource("provideOperators")
    void getOperator(String input, Operator expect) {
        // when
        final Operator actual = Operator.getOperator(input);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideOperators() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS)
                ,Arguments.of("-", Operator.MINUS)
                ,Arguments.of("*", Operator.MULTIPLE)
                ,Arguments.of("/", Operator.DIVIDE)
        );
    }
}