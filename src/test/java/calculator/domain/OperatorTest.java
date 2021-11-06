package calculator.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @DisplayName("덧셈을 할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "4,5,9", "2,3,5"})
    void plus(double left, double right, double expect) {
        Assertions.assertThat(Operator.PLUS.apply(left, right)).isEqualTo(expect);
    }

    @DisplayName("뺄셈을 할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,-1", "4,2,2", "2,100,-98"})
    void subtract(double left, double right, double expect) {
        Assertions.assertThat(Operator.MINUS.apply(left, right)).isEqualTo(expect);
    }

    @DisplayName("곱셈을 할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,2", "3,4,12", "5,6,30"})
    void multiply(double left, double right, double expect) {
        Assertions.assertThat(Operator.TIMES.apply(left, right)).isEqualTo(expect);
    }

    @DisplayName("나눗셈을 할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,0.5", "3,4,0.75", "1,10,0.1"})
    void divide(double left, double right, double expect) {
        Assertions.assertThat(Operator.DIVIDE.apply(left, right)).isEqualTo(expect);
    }

    @DisplayName("0으로 나눌 수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,0", "3,0"})
    void cannotDivideWithZero(double left, double right) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Operator.DIVIDE.apply(left, right);

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("0으로 나눌 수 없습니다.");
    }

    @DisplayName("사칙연산자가 아닌 기호는 연산자가 아니다.")
    @ParameterizedTest
    @ValueSource(strings = {"#", "&", "^", "!"})
    void isOperatorFalse(String symbol) {
        Assertions.assertThat(Operator.isOperator(symbol)).isFalse();
    }
}
