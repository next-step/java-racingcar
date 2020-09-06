package racingcar.domain.game.utils;

import org.junit.jupiter.api.Test;
import static racingcar.domain.game.utils.StringUtils.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void repeatDash() {
        assertThat(repeat("-", 3)).isEqualTo("---");
        assertThat(repeat("=", 4)).isEqualTo("====");
    }
}
