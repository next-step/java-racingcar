package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {
    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다.")
    void splitCommas() {
        final String input = "pobi,crong,honux";

        final String[] expected = input.split(",");
        final String[] result = StringUtil.splitCommas(input);

        assertThat(result).containsExactly(expected);
    }
}
