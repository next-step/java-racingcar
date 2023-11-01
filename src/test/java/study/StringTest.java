package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        String[] result2 = "1".split(",");
        assertThat(result).contains("1","2");
        assertThat(result).containsExactly("1","2");
        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substr() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).contains("1,2");
    }

    @DisplayName("요구사항3테스트")
    @Test
    void charat() {
        String result = "abc";
        assertThatThrownBy(() -> {
            assertThat(result.charAt(3));
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("Index: 2, Size: 3");
    }
}
