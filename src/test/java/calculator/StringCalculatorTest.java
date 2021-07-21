package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource({"3 + 4, 7", "3 + 4 + 7 + 9 + 11, 34"})
    void add(String input, String expected) {
        String actual = stringCalculator.execute(input);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource({"2 - 4, -2", "7 - 3 - 2, 2"})
    void sub(String input, String expected) {
        String actual = stringCalculator.execute(input);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource({"2 * 0, 0", "0 * 0, 0", "5 * 5 * 8, 200"})
    void mul(String input, String expected) {
        String actual = stringCalculator.execute(input);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource({"2 / 4, 0", "4 / 2, 2", " 15 / 3 / 2, 2"})
    void div(String input, String expected) {
        String actual = stringCalculator.execute(input);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("0으로 나눈 경우 테스트")
    @Test
    void divide0Test() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    stringCalculator.execute("4 / 0");
                }).withMessageMatching("0으로 나누는 연산은 수행할 수 없습니다.");

    }

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2, 10", "5 / 5 * 4 / 2 - 2 + 100, 100"})
    void multiOperatorTest(String input, String expected) {
        String actual = stringCalculator.execute(input);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("입력 값이 null 이거나 빈 공백 문자 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void blankTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    stringCalculator.execute(input);
                }).withMessageMatching("입력 값이 null 이거나 빈 공백 문자 입니다.");
    }

    @DisplayName("사칙연산 기호가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4 ^ 5", "4 $ 5"})
    void illegalOperatorTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    stringCalculator.execute(input);
                }).withMessageMatching("올바른 사칙연산 기호가 아닙니다.");
    }


}