package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String[] stringArray1 = "1,2".split(",");
        String[] stringArray2 = "1".split(",");

        assertThat(stringArray1).contains("1");
        assertThat(stringArray1).containsExactly("1", "2");

        assertThat(stringArray2).contains("1");
        assertThat(stringArray2).containsExactly("1");
    }

    @Test
    void subString() {
        String subString = "(1,2)";

        subString = subString.substring(1, subString.length() - 1);

        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException")
    void charAt() {
        String string = "abc";

        assertThatThrownBy(() -> {
            string.charAt(string.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageMatching("String index out of range: \\d+");
    }
}
