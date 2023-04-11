package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitTest() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substringTest() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    void indexOutOfBoundsExceptionTest() {
        String value = "abc";
        char expected = 'a';
        assertThatThrownBy(() -> {
            assertThat(value.charAt(0)).isEqualTo(expected);
            assertThat(value.charAt(3)).isEqualTo(expected);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
