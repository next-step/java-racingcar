package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split 활용")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("Substring 활용")
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("Exception 발생시키기")
    void charAt() {
        String sample = "abc";
        assertThatThrownBy(() ->{
            sample.charAt(10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 10");

    }
}
