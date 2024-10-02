package stringadder.delimiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomDelimiterNumberParserTest {

    private final CustomDelimiterNumberParser customDelimiterNumberParser = new CustomDelimiterNumberParser();

    @DisplayName("입력값에 커스텀 구분자 패턴이 있으면 true를 반환한다.")
    @Test
    void hasDelimiterReturnTrue() {
        // given
        String text = "//!\n1!2!3!";

        // when
        boolean result = customDelimiterNumberParser.hasDelimiter(text);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("입력값에 커스텀 구분자 패턴이 있으면 false를 반환한다.")
    @Test
    void hasDelimiterReturnFalse() {
        // given
        String text = "1!2%3";

        // when
        boolean result = customDelimiterNumberParser.hasDelimiter(text);

        // then
        assertThat(result).isFalse();
    }
}