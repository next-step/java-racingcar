package racingcar.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorLexerTest {
    @DisplayName("입력 문자열 null or empty")
    @Test
    public void inputStringIsNullOrEmpty() {
        assertThat(StringAddCalculatorLexer.analyze(null).getCalcString())
                .isNull();
        assertThat(StringAddCalculatorLexer.analyze("").getCalcString())
                .isNull();
    }

    @DisplayName("입력 문자열 기본 구분자 사용 케이스")
    @Test
    public void defaultDelimiter() {
        StringAddCalculatorLexer.LexicalAnalyzeResult result = StringAddCalculatorLexer.analyze("1,2,3");
        assertThat(result.getDelimiter())
                .isEqualTo(",|:");

        assertThat(result.getCalcString())
                .isEqualTo("1,2,3");
    }

    @DisplayName("입력 문자열 커스텀 구분자 사용 케이스")
    @Test
    public void customDelimiter() {
        StringAddCalculatorLexer.LexicalAnalyzeResult result = StringAddCalculatorLexer.analyze("//;\n1;2;3");
        assertThat(result.getDelimiter())
                .isEqualTo(";");

        assertThat(result.getCalcString())
                .isEqualTo("1;2;3");
    }

    @DisplayName("입력 문자열 커스텀 구분자로 2자 이상 사용 시 기본 구별자 사용 및 전체 입력 문자열를 calcString 으로 판단")
    @Test
    public void test3() {
        StringAddCalculatorLexer.LexicalAnalyzeResult result = StringAddCalculatorLexer.analyze("//;'\n1;2;3");
        assertThat(result.getDelimiter())
                .isEqualTo(",|:");

        assertThat(result.getCalcString())
                .isEqualTo("//;'\n1;2;3");
    }
}