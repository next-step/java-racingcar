package study.step4.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StringParser 테스트")
class StringParserTest {

    @DisplayName("전달받은 파라미터값을 기준으로 문자열을 분리한다")
    @Test
    void impl() {
        String[] result = StringParser.impl("pobi,crong,honux", ",");

        assertThat(result).containsExactly("pobi", "crong", "honux");
    }
}