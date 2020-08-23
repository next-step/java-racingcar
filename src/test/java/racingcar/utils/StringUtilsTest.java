package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.utils.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void repeatDash() {
        assertThat(StringUtils.repeat("-", 3)).isEqualTo("---");
        assertThat(StringUtils.repeat("=", 4)).isEqualTo("====");
    }
}
