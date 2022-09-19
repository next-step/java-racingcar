package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    @DisplayName("문자열 split 테스트")
    void splitTest() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 substring 테스트")
    void subStringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 charAt 테스트")
    void charAtTest() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
