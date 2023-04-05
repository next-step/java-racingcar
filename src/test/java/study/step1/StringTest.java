package study.step1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {


    @Test
    @DisplayName("문자열 분리 테스트 - 성공")
    void splitTwoStringTest() {
        String[] result = "1,2".split(",");
        assertThat(result.length).isEqualTo(2);
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 분리 테스트 - 성공 ")
    void splitOneStringTest() {
        String[] result = "1".split(",");
        assertThat(result.length).isEqualTo(1);
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("괄호 분리 - 성공 ")
    void removeBracketTest() {
        String txt = "(1,2)";
        String result = txt.substring(1, txt.length() -1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 문자를 하나 조회하는 테스트 - 실패 ")
    void chartAtTest() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abc".charAt(4);
                }).withMessageMatching(  "String index out of range: \\d+");
    }
}
