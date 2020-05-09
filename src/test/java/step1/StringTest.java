package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void testSplit() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    public void testSubstring() {
        String input = "(1,2)";
        String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드 IndexOutOfBoundsException 예외 테스트")
    @Test
    public void testCharAt() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
