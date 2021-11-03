package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String st = "(1,2)";
        String result = st.substring(1, st.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 test")
    void exception() {
        String st = "abc";
        assertThatThrownBy(() -> st.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range");
    }
}
