package racingcar.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DelimiterIntegerTokenizerTest {

    DelimiterIntegerTokenizer delimiterIntegerTokenizer;

    @BeforeEach
    void setUp() {
        delimiterIntegerTokenizer = new DelimiterIntegerTokenizer();
    }

    @DisplayName("기본 Delimiter로 토큰화 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2,3:4^4", "1,2,3^3", "1:2:3:4:5^5"}, delimiter = '^')
    void basicDelimiterTokenize(String input, int numberCount) {
        // when
        List<Integer> numberTokens =  delimiterIntegerTokenizer.tokenize(input);

        // then
        assertThat(numberTokens).hasSize(numberCount);
    }

    @DisplayName("Custom Delimiter로 토큰화 한다.")
    @Test
    void customDelimiterTokenize() {
        // given
        String inputWithCustomDelimiter = "//;\n1;2;3";

        // when
        List<Integer> numberTokens =  delimiterIntegerTokenizer.tokenize(inputWithCustomDelimiter);

        // then
        assertThat(numberTokens).hasSize(3);
        assertThat(numberTokens).containsExactly(1, 2, 3);
    }

    @DisplayName("숫자가 아닌 요소가 존재할 때 NumberFormatException을 던진다.")
    @Test
    void throwNumberFormatExceptionWithNonNumber() {
        // given
        String inputWithNonNumber = "1:k:3";

        // then
        assertThrows(NumberFormatException.class, () -> delimiterIntegerTokenizer.tokenize(inputWithNonNumber));
    }

    @DisplayName("음수인 요소가 존재할 때 IllegalArgumentException을 전진다.")
    @Test
    void throwIllegalArgumentExceptionWithNegativeNumber() {
        // given
        String inputWithNegativeNumber = "1:3:-4";

        // then
        assertThrows(IllegalArgumentException.class, () -> delimiterIntegerTokenizer.tokenize(inputWithNegativeNumber));
    }
}