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
    @DisplayName("들어온 문자열이 없거나 비어있을 때 처리 관련 Test")
    @ValueSource(strings = {"", " ", "   "})
    @NullAndEmptySource
    void inputNullTest(String input) {
//        String trimInput = input.trim();
        assertThat(input == null || input.isBlank()).isTrue();
    }


}
