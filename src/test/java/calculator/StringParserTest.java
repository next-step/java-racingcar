package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {

    @DisplayName("한자리 문자열은 그대로 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3"})
    void singleString(String text) {
        assertThat(StringParser.splitNumberString(text)).containsExactly("3");
    }

    @DisplayName("쉼표를 구분자로 가지는 문자열을 파싱할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3"})
    void commaString(String text) {
        assertThat(StringParser.splitNumberString(text)).containsExactly("1", "2", "3");
    }

    @DisplayName("콜론을 구분자로 가지는 문자열을 파싱할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:3"})
    void colonString(String text) {
        assertThat(StringParser.splitNumberString(text)).containsExactly("1", "2", "3");
    }

    @DisplayName("쉼표와 콜론은 구분자로 가지는 문자열을 파싱할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    void commaAndColonString(String text) {
        assertThat(StringParser.splitNumberString(text)).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자를 가지는 문자열을 파싱할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//@\n1@2@3"})
    void customDelimiter(String text) {
        assertThat(StringParser.splitNumberString(text)).containsExactly("1", "2", "3");
    }

    @DisplayName("기본 구분자와 커스텀 구분자를 모두 가지는 문자열을 파싱할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//#\n1,2:3#4"})
    void defaultAndCustomDelimiter(String text) {
        assertThat(StringParser.splitNumberString(text)).containsExactly("1", "2", "3", "4");
    }
}
