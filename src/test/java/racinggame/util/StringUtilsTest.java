package racinggame.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racinggame.util.StringUtils;

class StringUtilsTest {

    @Test
    void repeat_String() {
        final String repeatString = StringUtils.repeat("*", 5);

        assertThat(repeatString).isEqualTo("*****");
    }
}
