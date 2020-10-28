package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - \"1,2\" 를 split 하여 \"1\" 과 \"2\" 로 분리된 배열을 확인")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항2 - \"(1,2)\" 를 substring 하여 괄호를 제거하고 \"1,2\" 문자열을 확인")
    void substring() {
        String data = "(1,2)";

        String substringResult = data.substring(1, data.length() - 1);
        assertThat(substringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3-1 - \"abc\" 를 charAt() 을 활용하여 문자를 가져오는 테스트")
    void charAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("요구사항3-2 - StringIndexOutOfBoundsException 발생 테스트")
    void expectedStringOutOfIndexException() {

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                "abc".charAt(3);
            }).withMessageContaining("String index out of range: 3");
    }
}
