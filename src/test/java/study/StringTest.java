package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    @Test
    @DisplayName("문자열에서 ,로 split 하는 테스트")
    void splitTest() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
        assertThat(data).containsExactly("1","2");
    }

    @Test
    @DisplayName("괄호를 제외한 문자출력 테스트")
    void substringTest() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAtTest() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            assertThat(str.charAt(3)).isEqualTo("d");
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("boom");
    }
}
