package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }


    @Test
    void removeBracket() {
        String str = "(1,2)";
        assertThat(str.substring(1,4)).isEqualTo("1,2");
    }


    @Test
    @DisplayName("특정 위치의 문자를 벗어나면 StringIndexOutOfBoundsException")
    void charAt() {
        String str = "abc";
        int index = 12;

        assertThatThrownBy(() -> str.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: ")
                .hasMessageContaining("%d", index);
    }
}
