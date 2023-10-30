package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] split01 = "1,2".split(",");
        assertThat(split01).contains("1", "2");

        String[] split02 = "1".split(",");
        assertThat(split02).containsExactly("1");
    }

    @Test
    void subString() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()의 StringIndexOutOfBoundsException 테스트")
    void charAt() {
        String chars = "abc";
        assertThatThrownBy(() -> {
            chars.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: ");
    }
}
