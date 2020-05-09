package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String 문자열 스플릿(split) 테스트")
    void splitTest() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");

        values = "1".split(",");
        assertThat(values).containsExactly("1");
    }

    @Test
    @DisplayName("String 문자열 자르기(substring) 테스트")
    void substringTest() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 문자열 위치값 가져오는 테스트")
    void charAtTestSuccess() {
        String value = "abc";
        assertThat(value.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("String 문자열 charAt assertThatThrownBy 에러 테스트")
    void charAtAssertThatThrownByTest() {
        String value = "abc";
        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: 3");
    }

    @Test
    @DisplayName("String 문자열 charAt assertThatExceptionOfType 에러 테스트")
    void charAtAssertThatExceptionOfTypeTest() {
        String value = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(4);
                }).withMessageContaining("range: 4");
    }

}
