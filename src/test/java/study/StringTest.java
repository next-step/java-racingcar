package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void splitTest() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result1).contains("1","2");
        assertThat(result2).contains("1");

        assertThat(result1).containsExactly("1","2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substringTest() {
        String result = "(1,2)".substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 위치 값 벗어날 시 StringIndexOutOfBoundsException 발생")
    void charAtTest() {

        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4))
                .withMessageMatching("String index out of range: \\d+");
    }
}
