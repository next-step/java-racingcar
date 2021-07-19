package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("요구사항 1")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항 2")
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 - 특정 위치 문자 가져오기, StringIndexOutOfBoundsException 발생 확인")
    void charAt() {
        String data = "abc";
        char result = data.charAt(1);

        assertThat(result).isEqualTo('b');

        assertThatThrownBy(() -> {
            data.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage("String index out of range: 4");
    }
}
