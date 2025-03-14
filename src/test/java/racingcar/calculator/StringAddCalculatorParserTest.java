package racingcar.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorParserTest {
    @DisplayName("null or 빈문자열 파싱")
    @Test
    public void parseNullOrEmpty() {
        assertThat((new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("")).parse()))
                .containsExactly();
        assertThat((new StringAddCalculatorParser(StringAddCalculatorLexer.analyze(null)).parse()))
                .containsExactly();
    }

    @DisplayName("기본 구분자 \",\"로 이루어진 문자열 파싱")
    @Test
    public void parseCommaSemicolonDelimiter() {
        assertThat((new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("1,2,3")).parse()))
                .containsExactly(1,2,3);
    }

    @DisplayName("기본 구분자 \":\"로 이루어진 문자열 파싱")
    @Test
    public void parseColonDelimiter() {
        assertThat((new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("1:2:3")).parse()))
                .containsExactly(1,2,3);
    }

    @DisplayName("기본 구분자 \",|:\"로 이루어진 문자열 파싱")
    @Test
    public void parseCommaOrColonDelimiter() {
        assertThat((new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("1,2:3")).parse()))
                .containsExactly(1,2,3);
    }

    @DisplayName("유효하지 않은 문자열 포맷 파싱")
    @Test
    public void parseInvalidFormat() {
        assertThatThrownBy(() -> new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("1,2:3a")).parse())
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("For input string");

        assertThatThrownBy(() -> new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("1,2:3;4")).parse())
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("For input string");

        assertThatThrownBy(() -> new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("1,2:3;4:-5")).parse())
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("For input string");
    }

    @DisplayName("음수 파싱")
    @Test
    public void parseNegativeNumber() {
        assertThatThrownBy(() -> new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("1,2:-3")).parse())
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("positive number is allowed.");

        assertThatThrownBy(() -> new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("1,-2:3")).parse())
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("positive number is allowed.");

        assertThatThrownBy(() -> new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("1,-2:3;4")).parse())
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("positive number is allowed.");
    }

    @DisplayName("커스텀 구분자 지정, 정상 파싱")
    @Test
    public void parseCustomDelimiter() {
        assertThat(new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("//;\n1;2;3")).parse())
                .containsExactly(1,2,3);
    }

    @DisplayName("커스텀 구분자 지정, 기본 구분자 사용 불가")
    @Test
    public void parseCustomDelimiterButUseDefaultDelimiter() {
        assertThatThrownBy(() -> new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("//;\n1,2:3")).parse())
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("For input string");
    }

    @DisplayName("커스텀 구분자 지정, 음수 파싱")
    @Test
    public void parseCustomDelimiterNegativeNumber() {
        assertThatThrownBy(() -> new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("//;\n1;2;-3")).parse())
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("positive number is allowed.");

        assertThatThrownBy(() -> new StringAddCalculatorParser(StringAddCalculatorLexer.analyze("//;\n1;-2;3")).parse())
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("positive number is allowed.");
    }
}