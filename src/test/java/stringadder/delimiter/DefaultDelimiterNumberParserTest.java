package stringadder.delimiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultDelimiterNumberParserTest {

    private DefaultDelimiterNumberParser defaultDelimiterNumberParser = new DefaultDelimiterNumberParser();

    @DisplayName("입력값에 기본 구분자인 ,와 :가 있으면 true를 반환한다.")
    @Test
    void hasDelimiterReturnTrue() {
    	// given
        String text = "1,2:3";

    	// when
        boolean result = defaultDelimiterNumberParser.hasDelimiter(text);

        // then
        assertThat(result).isTrue();
    }
    @DisplayName("입력값에 기본 구분자인 ,와 :가 없으면 false를 반환한다.")
    @Test
    void hasDelimiterReturnFalse() {
        // given
        String text = "1!2%3";

        // when
        boolean result = defaultDelimiterNumberParser.hasDelimiter(text);

        // then
        assertThat(result).isFalse();
    }
}