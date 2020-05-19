package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringValidatorTest {

    @Test
    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우")
    void checkNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            StringValidator.checkNull(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "  " })
    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우")
    void checkEmpty(String param) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            StringValidator.checkEmpty(param);
        });
    }

    @ParameterizedTest
    @CsvSource({ "1, true", "-, false", "3.123, true", "3123123, true" })
    @DisplayName("String 값이 숫자인지 확인")
    void isNumber(String param, boolean expected) {
        assertThat(StringValidator.isNumber(param)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = { "+", "-", "*", "/" })
    @DisplayName("사칙연산 기호 확인")
    void checkOperator(String operator) {
        StringValidator.checkOperator(operator);
    }

    @ParameterizedTest
    @ValueSource(strings = { "a", "0", " ", " asd" })
    @DisplayName("사칙연산 기호가 아닌것 확인")
    void checkOperator_withNonOperator(String operator) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            StringValidator.checkOperator(operator);
        });
    }
}
