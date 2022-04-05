import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split")
    void requirementFirst() {
        String firstStr = "1,2";
        String secondStr = "1";

        assertThat(firstStr.split(",")).isEqualTo(new String[]{"1", "2"});
        assertThat(secondStr.split(",")).isEqualTo(new String[]{"1"});
    }

    @Test
    @DisplayName("substring")
    void requirementSecond() {
        String str = "(1,2)";

        assertThat(str.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt-IndexOutOfBoundsException")
    void requirementThird() {
        String str = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(4);
                }).withMessage("String index out of range: 4");
    }
}
