package study;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    // 요구사항 1
    @Test
    void split() {
        Assertions.assertThat("1,2".split(",")).containsExactly("1", "2");
        Assertions.assertThat("1".split(",")).containsExactly("1");
    }

    // 요구사항 2
    @Test
    void subString() {
        String result = "(1,2)".substring(1, "(1,2)".length()-1);
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    // 요구사항 3
    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치값을 벗어나면 StringIndexOutOfBoundsException 가 발생한다.")
    void charAtTest() {
        Assertions.assertThat("abc".charAt(1)).isEqualTo('b');
        Assertions.assertThatThrownBy(() -> "abc".charAt("abc".length() + 1))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");

    }
}
