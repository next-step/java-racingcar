package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항1. 문자가 \",\"로 분리되는지 확인")
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항2. 입력값에서 () 제거하고 \"1,2\"를 반환")
    void subStringTest() {
        String input = "(1,2)";
        String result = input.substring(1, input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3. 특정문자 위치값을 벗어나는 경우 에러가 발생하는지 확인")
    void charAtTest() {
        String input = "abc";
        int index = 10;
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
    }
}
