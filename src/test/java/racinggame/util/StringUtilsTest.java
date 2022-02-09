package racinggame.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void repeat_String() {
        final String repeatString = StringUtils.repeat("*", 5);

        assertThat(repeatString).isEqualTo("*****");
    }
}
