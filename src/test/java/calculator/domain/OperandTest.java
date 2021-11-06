package calculator.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperandTest {

    @DisplayName("null 또는 빈문자열은 피연사자가 될 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createFailWithNullAndEmptyString(String value) {
        ThrowableAssert.ThrowingCallable callable = () -> Operand.of(value);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("올바른 형식의 피연산자가 아닙니다.");
    }

    @DisplayName("숫자가 아닌 문자열은 피연산자가 될 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"n", "e", "x", "t"})
    void createFailWithAlphaString(String value) {
        ThrowableAssert.ThrowingCallable callable = () -> Operand.of(value);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("올바른 형식의 피연산자가 아닙니다.");
    }

    @DisplayName("숫자인 문자열을 입력받으면 피연산자로 만들 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void create(String value) {
        Assertions.assertThat(Operand.of(value).getValue()).isEqualTo(Double.parseDouble(value));
    }
}
