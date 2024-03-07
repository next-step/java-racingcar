package study;

import StringCalculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("들어온 문자열이 null일 때 Valid Test")
    @NullAndEmptySource
    void inputNullTest(String input) {
        assertThat(input == null || input.isEmpty()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("들어온 문자열 내부에 blank가 존재할 때 Valid Test")
    @ValueSource(strings = {"", " ", "   "})
    void inputBlankTest(String input) {
        String trimInput = input.trim();
        assertThat(trimInput.isBlank()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("들어온 문자열이 null일 때 변환 Test")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "        "})
    void inputNullProcessTest(String input) {
        if (input == null || input.isBlank()) {
            input = "0";
        }
        assertThat(input).isEqualTo("0");
    }

    @ParameterizedTest
    @DisplayName("들어온 문자열 내부에 blank가 존재할 때 변환 Test")
    @ValueSource(strings = {"a    a", "b c", " a b "})
    void inputBlankProcessTest(String input) {
        String trimInput = input.replace(" ", "");
        assertThat(trimInput.contains(" ")).isFalse();
    }


}
