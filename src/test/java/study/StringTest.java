package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("요구사항1, 문자열 분리 테스트")
    void split() {
        String testWord = "1,2";

        String[] result = testWord.split(",");

        assertThat(result).containsExactly("1", "2");

        String singleWord = "1";

        result = singleWord.split(",");

        assertThat(result).containsExactly("1");
    }
    @Test
    @DisplayName("요구사항2, 부분 문자열 테스트")
    void substring() {
        String testWord = "(1,2)";

        String result = testWord.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3, 특정 위치 문자열 및 예외 테스트")
    void chatat() {
        String testWord = "abc";

        assertThat(testWord.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            testWord.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 4");
    }
}
