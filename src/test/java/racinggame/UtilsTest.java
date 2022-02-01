package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void repeat_String() {
        final String repeatString = Utils.repeat("*", 5);

        assertThat(repeatString).isEqualTo("*****");
    }
}
