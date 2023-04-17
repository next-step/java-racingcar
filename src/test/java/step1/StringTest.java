package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("한개 이상의 텍스트 분리")
    void splitOneMoreText() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("한개의 텍스트 분리")
    void splitOneText() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    @DisplayName("괄호제거 후 값 반환")
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치의 문자를 가져올 때 범위를 벗어나는 경우 예외 발생1")
    void charAt() {
        String text = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    text.charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }

    @Test
    @DisplayName("특정위치의 문자를 가져올 때 범위를 벗어나는 경우 예외 발생2")
    void charAt2() {
        String text = "abc";
        assertThatThrownBy(() ->{
            text.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}