package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class TextSplitterTest {

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3", "1:2:3", "//;\n1;2;3" })
    @DisplayName("올바른 입력값이 들어오는 경우")
    void correctInputTest(final String text) {
        assertThat(TextSplitter.split(text)).containsExactlyInAnyOrder("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = { "1;2;3" })
    @DisplayName("잘못된 입력값이 들어오는 경우")
    void wrongInputTest(final String text) {
        assertThat(TextSplitter.split(text)).containsExactly(text);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열이 입력값으로 들어오는 경우")
    void nullOrBlankInputTest(final String text) {
        assertThat(TextSplitter.split(text)).containsExactlyInAnyOrder("0");
    }
}