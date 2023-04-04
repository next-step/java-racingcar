package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split() 메소드가 반환하는 문자 배열을 확인한다.")
    void split() {
        String[] strings = "1,2".split(",");
        assertThat(strings).containsExactly("1", "2");

        strings = "1".split(",");
        assertThat(strings).containsOnly("1");
    }

    @Test
    @DisplayName("substring()를 통해, 첫 번째와 마지막 문자를 제외한 문자열을 확인한다.")
    void substring() {
        String string = "(1,2)";
        assertThat(string.substring(1, string.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()는 범위를 벗어나면, StringIndexOutOfBoundsException 발생한다.")
    void charAt() {
        String string = "abc";
        assertThatThrownBy(() -> {
            string.charAt(string.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", string.length());
    }
}
