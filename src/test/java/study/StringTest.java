package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName(",로 문자열을 나누는 split 테스트")
    void split() {
        String[] splits = "1,2".split(",");

        assertThat(splits).contains("1");
        assertThat(splits).containsExactly("1", "2");
    }

    @Test
    @DisplayName("양 끝의 소괄호를 삭제하는 substring 테스트")
    void substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()을 통해 특정 위치의 문자를 가져오는 테스트")
    void charAt() {
        String testString = "abc";
        assertThat(testString.charAt(0)).isEqualTo('a');
        assertThat(testString.charAt(1)).isEqualTo('b');
        assertThat(testString.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 인덱스를 벗어나는 경우 charAt() 오류 발생")
    void CharAtIndexError() {
        assertThatThrownBy(() -> {
            char ch = "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
