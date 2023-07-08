package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NonNegativeNumberTest {

    @ParameterizedTest
    @ValueSource(ints = { 0, 1 })
    @DisplayName("음이 아닌 정수를 입력받아 객체를 생성하는 경우")
    void createNonNegativeNumber(final int value) {
        final NonNegativeNumber number = NonNegativeNumber.of(value);
        assertThat(number.intValue()).isEqualTo(value);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백을 입력받아 객체를 생성하는 경우")
    void createNullOrBlank(final String value) {
        final NonNegativeNumber number = NonNegativeNumber.of(value);
        assertThat(number.intValue()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1" })
    @DisplayName("잘못된 값을 입력받아 객체를 생성하는 경우")
    void createNegativeNumberTest(final String value) {
        assertThatThrownBy(() -> NonNegativeNumber.of(value)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}