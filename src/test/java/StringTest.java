import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("2");
    }

    @Test
    void split_substring() {
        String requireStr = "(1,2)";
        String result = requireStr.substring(1,4);
        System.out.println(result);
    }

    @DisplayName("charAt Exception 체크")
    @Test
    void test_charAt() {
        String requireStr = "abc";

        assertThatThrownBy(() -> {
            requireStr.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
