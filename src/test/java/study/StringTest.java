package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항1 : split 테스트")
    void split() {
        String[]  result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항2 : substring 테스트")
    void substring() {
        String given = "(1,2)";
        String result = given.substring(1, given.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3-1 : 특정위치 문자 가져오기")
    void charAt() {
        String given = "abc";
        assertThat('a').isEqualTo(given.charAt(0));
    }

    @Test
    @DisplayName("요구사항3-2 : 특정위치 문자 가져오기 예외처리")
    void charAtException() {
        String given = "abc";
        assertThatThrownBy(() ->{
            given.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
