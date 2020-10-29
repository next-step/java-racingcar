package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split , substring 테스트")
    void stringClass() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");

        String input2 = "(1,2)";
        String expect2 = "1,2";

        String result2 = input2.substring(1, input2.length() - 1);
        assertThat(result2).isEqualTo(expect2);
    }

    @Test
    @DisplayName("charAt 의 StringIndexOutOfBoundsException 테스트")
    void stringIndexOutOfBoundsException() {
        String input = "abc";
        int outOfBoundInteger = 4;

        assertThatThrownBy(() -> {
            input.charAt(outOfBoundInteger);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");
    }

}
