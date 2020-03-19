package calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

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
                .isThrownBy(() -> { Operator.isOperator(wrongOperatorText); }
        );
    }

    @DisplayName("사칙 연산자를 성공적으로 반환한다.")
    @Test
    void getOperator() {
        // given
        final String plusOperatorText = "+";
        final String minusOperatorText = "-";
        final String multipleOperatorText = "*";
        final String divideOperatorText = "/";

        final Operator plusExpect = Operator.PLUS;
        final Operator minusExpect = Operator.MINUS;
        final Operator multipleExpect = Operator.MULTIPLE;
        final Operator divideExpect = Operator.DIVIDE;

        // when
        final Operator plusActual = Operator.getOperator(plusOperatorText);
        final Operator minusActual = Operator.getOperator(minusOperatorText);
        final Operator multipleActual = Operator.getOperator(multipleOperatorText);
        final Operator divideActual = Operator.getOperator(divideOperatorText);

        // then
        assertAll(
                () -> assertThat(plusActual).isEqualTo(plusExpect)
                ,() -> assertThat(minusActual).isEqualTo(minusExpect)
                ,() -> assertThat(multipleActual).isEqualTo(multipleExpect)
                ,() -> assertThat(divideActual).isEqualTo(divideExpect)
        );
    }
}