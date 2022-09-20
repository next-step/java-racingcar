import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringTest {
    // 요구사항1
    @Test
    public void splitTest() {
        assertThat("1,2".split(",")).containsExactly("1", "2");

        assertThat("1".split(",")).containsExactly("1");
    }

    // 요구사항2
    public String numberStrings(String input) {
        return input.substring(1, input.length() - 1);
    }

    // 요구사항3
    @Test
    @DisplayName("String의 charAt() 메소드 동작 확인")
    public void chartAtTest() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(-1));
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3));
    }
}