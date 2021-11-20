package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("이름은 null 또는 빈문자열일 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createFailWithNullOrEmptyValue(String value) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> new Name(value);

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("이름은 null 또는 공백일 수 없습니다.");
    }

    @DisplayName("이름은 1글자 미만 또는 5글자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"javakotlin", "nextstep", "javascript"})
    void createFail(String value) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> new Name(value);

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("이름은 최소 1글자 이상 5글자 이하여야만 합니다.");
    }
}
