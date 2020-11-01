package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TestStringStringCalculator {
    StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("Null, 빈문자열 입력")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "  "})
    void test_with_null_or_empty_string(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(input);
        });
    }

    @DisplayName("양의정수 + 양의정수 = 양의정수")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2"})
    void test_with_plus_and_positive_result(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(3);
    }

    @DisplayName("음의정수 + 음의정수 = 음의정수")
    @ParameterizedTest
    @ValueSource(strings = {"-1 + -2"})
    void test_with_plus_and_negative_result(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(-3);
    }

    @DisplayName("양의정수 - 양의정수 = 양의정수")
    @ParameterizedTest
    @ValueSource(strings = {"2 - 1"})
    void test_with_minus_and_positive_result(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(1);
    }

    @DisplayName("양의정수 - 양의정수 = 음의정수")
    @ParameterizedTest
    @ValueSource(strings = {"1 - 2"})
    void test_with_subtract_and_negative_result(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(-1);
    }

    @DisplayName("양의정수 * 양의정수 = 양의정수")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 2"})
    void test_with_multiple_and_positive_result(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(2);
    }

    @DisplayName("양의정수 * 음의정수 = 음의정수")
    @ParameterizedTest
    @ValueSource(strings = {"1 * -2"})
    void test_with_multiple_and_negative_result(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(-2);
    }

    @DisplayName("양의정수 / 양의정수 = 양의정수")
    @ParameterizedTest
    @ValueSource(strings = {"2 / 2"})
    void test_with_divide_and_positive_result(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(1);
    }

    @DisplayName("음의정수 / 양의정수 = 음의정수")
    @ParameterizedTest
    @ValueSource(strings = {"-2 / 2"})
    void test_with_divide_and_negative_result(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(-1);
    }

    @DisplayName("다항식에 대해서 계산")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void test_with_complex_input(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(10);
    }

    @DisplayName("다항식에 대해서 계산")
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2,10", "10 * 10 / 10 - 10 + 1,1"})
    void test_with_complex_inputs_by_using_CsvSource(String input, String result) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(Integer.parseInt(result));
    }
}
