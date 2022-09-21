package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split test")
    void split() {
        String[] numStrArr = "1,2".split(",");
        assertThat(numStrArr).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring test")
    void substring() {
        String str = "(1,2)";
        String numsStr = str.substring(1, str.length() - 1);
        assertThat(numsStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt test")
    void charAt() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range");
    }
}
