package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitWithMultiple() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitWithSingle() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void ignoreBracket() {
        String withBracketStr = "(1,2)";
        String withoutBracketStr = withBracketStr.substring(1, 4);
        assertThat(withoutBracketStr).isEqualTo("1,2");
    }

    @Test
    void positionToString() {
        String origin = "abc";
        assertThat(origin.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> origin.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
