package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2를 split 하면 1 또는 2가 아닌 값을 반환할 수 없다.")
    void splitContainsFailTest() {
        final String[] target = "1,2".split(",");
        assertThat(target).doesNotContain("3");
    }

    @Test
    @DisplayName("1,2를 split 하면 1 또는 2로 분리할 수 있다.")
    void splitContainsTest() {
        final String[] target = "1,2".split(",");
        assertThat(target).contains("1", "2");
    }

    @Test
    @DisplayName("1을 split 하면 1이 아닌 값을 반환할 수 없다.")
    void splitContainsExactlyFailTest() {
        final String[] target = "1".split(",");
        assertThat(target).doesNotContain("1,", "2");
    }

    @Test
    @DisplayName("1을 split 하면 1만을 반환한다.")
    void splitContainsExactlyTest() {
        final String[] target = "1".split(",");
        assertThat(target).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)에서 subString 하면 1,2 를 반환할 수 있다.")
    void substringTest() {
        final String substringExample = "(1,2)";
        final String target = substringExample.substring(substringExample.indexOf("(") + 1, substringExample.indexOf(")"));
        assertThat(target).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 길이를 초과하는 위치의 값을 찾을 수 없다.")
    void chartAtFailTest() {
        assertThatThrownBy(() ->
            "abc".charAt(3)
        ).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    @Test
    @DisplayName("문자열의 특정 위치의 값을 찾을 수 있다.")
    void chartAtTest() {
        final char target = "abc".charAt(2);
        assertThat(target).isEqualTo('c');
    }

}
