package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항 1 : split")
    void splitTest() {
        //given
        String[] result = "1,2".split(",");
        // when & then
        assertThat(result).contains("1","2");

        //given
        String[] result2 = "1".split(",");
        // when & then
        assertThat(result2).contains("1");
    }

    @Test
    @DisplayName("요구사항 2: substring")
    void subStringTest() {
        //given
        String result = "(1,2)".substring(1, 4);
        // when & then
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드로 특정 위치 문자 가져올 때 위치 값을 벗어나면 예외 발생 테스트")
    void charAtTest() {
        //given
        String s = "abc";

        // when & then
        assertThatThrownBy(() -> {
            s.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("%s","Index 3 out of bounds for length 3");
    }
}
