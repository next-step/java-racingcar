package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static study.step2.StringAddCalculator.calculate;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "1) 빈 문자열 or null 입력: {arguments}")
    @NullSource
    @EmptySource
    void empty_string_and_null(String input) {
        int result = calculate(input);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("2) 숫자 하나 입력")
    @Test
    void only_digit() {
        int result = calculate("7");
        assertThat(result).isEqualTo(7);
    }

    @DisplayName("3) 컴마로 구분된 두 수의 합")
    @Test
    void two_numbers_with_comma() {
        int result = calculate("3,4");
        assertThat(result).isEqualTo(7);
    }

    @ParameterizedTest(name = "4) 컴마/콜론으로 구분된 여러 수의 합: {arguments}")
    @ValueSource(strings = {
            "3:4",
            "1,2:4",
            "1:2,4",
            "1:2:4",
            "1,2,4"
    })
    void numbers_with_comma_and_colon(String input) {
        int result = calculate(input);
        assertThat(result).isEqualTo(7);
    }

    @ParameterizedTest(name = "5) 커스텀 구분자: {arguments}")
    @ValueSource(strings = {
            "// \n1 6",
            "//0\n304",
            "//@\n1@2@4",
            "//ㅁ\n1ㅁ2ㅁ4",
            "//NEXT\n1NEXT2NEXT4"
    })
    void custom_delimiter(String input) {
        int result = calculate(input);
        assertThat(result).isEqualTo(7);
    }

    @ParameterizedTest(name = "6) 숫자 이외의 값 또는 음수 입력: {arguments}")
    @ValueSource(strings = {
            "넥스트",
            "a",
            "-1",
            "3:-4",
            "3,b:4",
            "//@\n1@-2@4",
            "//ㅁ\n-1ㅁ2ㅁ4",
            "//NEXT\n1NEXT-6",
            "//NEXT\n1NEXT-6NEXT1"
    })
    void non_numeric_and_negative_number(String input) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            int result = calculate(input);
        });
    }

}
