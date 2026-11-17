package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountParserTest {
    @Test
    @DisplayName("숫자 문자열을 정수로 변환한다")
    void parseCount() {
        CountParser countParser = new CountParser();

        int result = countParser.parse("3");

        assertThat(result).isEqualTo(3);
    }
}
