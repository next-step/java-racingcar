package calculator.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionTest {

    @DisplayName("입력값에 올바르지 않은 문자열이 포함되어있으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"2 + e / 3", "2 & 1 - 3", "2 + a + b"})
    void verifyFalse(String expression) {
        ThrowableAssert.ThrowingCallable callable = () -> Expression.verify(expression);

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("입력값에 올바르지 않은 문자열이 포함되어 있습니다.");
    }

    @DisplayName("입력값이 null 또는 빈문자열이면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    void verifyIsNullOrEmpty(String expression) {
        ThrowableAssert.ThrowingCallable callable = () -> Expression.verify(expression);

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("입력값은 null 또는 빈문자열일 수 없습니다.");
    }

    @DisplayName("숫자와 사칙연산 기호만을 포함한 입력을 올바른 식으로 간주한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "3 * 4", "5 - 4 / 7"})
    void verifyTrue(String expression) {
        Assertions.assertThat(Expression.verify(expression)).isEqualTo(expression);
    }
}
