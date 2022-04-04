package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항 1 : split() 메서드 테스트")
    void splitTest() {
        String[] actual1 = "1,2".split(",");
        assertThat(actual1).contains("1", "2");

        String[] actual2 = "1".split(",");
        assertThat(actual2).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 : substring() 메서드 테스트")
    void substringTest() {
        String data = "(1,2)";
        String actual = data.substring(1, data.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 : charAt() 메서드 테스트")
    void charAtTest() {
        String actual = "abc";

        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항 3 : 문자열 위치값 범위 벗어날 시 StringIndexOutOfBoundsException 발생 (assertThatThrownBy 메서드 이용)")
    void charAtFailTest1() {
        String actual = "abc";
        assertThatThrownBy(() -> {
            actual.charAt(actual.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", actual.length());
    }

    @Test
    @DisplayName("요구사항 3 : 문자열 위치값 범위 벗어날 시 StringIndexOutOfBoundsException 발생 (assertThatExceptionOfType 메서드 이용)")
    void charAtFailTest2() {
        String actual = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    actual.charAt(actual.length());
                }).withMessageMatching("String index out of range: \\d+");
    }
}
