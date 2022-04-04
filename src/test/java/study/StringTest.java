package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        int from = 1;
        int to = str.length() - 1;
        assertThat(str.substring(from, to)).isEqualTo("1,2");
    }

    @DisplayName("String의 charAt() 메서드를 활용해 특정 위치의 문자를 가져옴")
    @Test
    void charAt() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 IndexOutOfBoundsException 발생 확인")
    @Test
    void charAt_exception() {
        String str = "abc";
        int outOfIndex = str.length() + 1;
        assertThatThrownBy(() -> {
            str.charAt(outOfIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: " + outOfIndex);
    }
}
