package step3.study.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    @DisplayName("숫자형식이 아닌지 테스트")
    void wrongNumberCheck(String str) {
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    Validator.numberCheck(str);
                }).withMessage("숫자형식이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @DisplayName("빈 문자열인지 테스트")
    void isEmptyStringTest(String str) {
        assertTrue(Validator.isEmpty(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc"})
    @DisplayName("빈 문자열이 아닌지 테스트")
    void isNotEmptyStringTest(String str) {
        assertTrue(Validator.isNotEmpty(str));
    }
}
