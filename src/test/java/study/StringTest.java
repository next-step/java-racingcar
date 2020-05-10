package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    void split() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
    }

    @Test
    void charAt() {
        String result = "abc";
        assertThatThrownBy(() -> { result.charAt(3); })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, size: 3");
    }

    private void getCharAt(String result, int i) {
    }
}
