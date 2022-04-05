package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("스플릿 테스트")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        int firstIndex = 1;
        int lastIndex = data.length() - 1;
        String substringData = data.substring(firstIndex, lastIndex);
        assertThat(substringData).isEqualTo("1,2");
    }

    @DisplayName("위치 값이 벗어날때 에러 발생")
    @Test
    void StringIndexOutOfBoundException() {
        String data = "abc";
        assertThatThrownBy(() -> data.charAt(data.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    data.charAt(data.length());
                }).withMessageMatching("String index out of range: \\d+");
    }
}
