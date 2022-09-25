package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void check_space_null(String str) {
        assertEquals(0, StringCalculator.splitAndSum(str));
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @Test
    void parse_string_to_number() {
        assertEquals(5, StringCalculator.splitAndSum("5"));
    }

    @DisplayName("숫자 두개를 콤마 구분자로 입력할 경우 두 숫자의 합을 반환")
    @Test
    void separate_comma() {
        int result = StringCalculator.splitAndSum("1,2,3");
        assertEquals(6, result);
    }

    @DisplayName("구분자로 콤마와 콜론 사용")
    @Test
    void colon_seperated_test() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertEquals(6, result);
    }

    @DisplayName("커스텀 구분자 사용")
    @Test
    public void use_custom_delimiter() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertEquals(6, result);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생")
    @Test
    void when_negative_expected_exception() {
        assertThrows(RuntimeException.class, () -> {
            StringCalculator.splitAndSum("-100,50");
        });
    }
}