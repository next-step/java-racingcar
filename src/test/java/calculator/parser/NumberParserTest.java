package calculator.parser;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberParserTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "1", "1,2", "1,2,3", "//;\n1;2;3" })
    @DisplayName("올바른 숫자들을 입력받는 경우")
    void correctNumbersTest(final String text) {
        final NumberParser parser = NumberParser.getInstance();
        assertThatCode(
                () -> parser.parse(text)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = { "1;2", "-1,2" })
    @DisplayName("잘못된 값을 입력받는 경우")
    void incorrectNumbersTest(final String text) {
        final NumberParser parser = NumberParser.getInstance();
        assertThatCode(
                () -> parser.parse(text)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}