package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("문자열 분리를 성공한다.")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 자르기를 성공한다.")
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertEquals(result,"1,2");
    }

    @Test
    @DisplayName("IndexOutOfBoundsException 테스트")
    void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
