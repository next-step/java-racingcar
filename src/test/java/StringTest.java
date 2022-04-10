import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split")
    void requirementFirst() {
        assertThat("1,2".split(",")).isEqualTo(new String[]{"1", "2"});
        assertThat("1".split(",")).isEqualTo(new String[]{"1"});
    }

    @Test
    @DisplayName("substring")
    void requirementSecond() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt-IndexOutOfBoundsException")
    void requirementThird() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(4);
                }).withMessage("String index out of range: 4");
    }
}
