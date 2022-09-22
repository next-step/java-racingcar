package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("When split multiple strings, then return string array with exactly same elements")
    void splitMultipleStrings() {
        String[] actual1 = "1,2".split(",");
        assertThat(actual1).hasSize(2);
        assertThat(actual1).containsExactly("1", "2");
    }

    @Test
    @DisplayName("When split one string, then return string array with exactly same element")
    void splitOneString() {
        String[] actual2 = "1".split(",");
        assertThat(actual2).hasSize(1);
        assertThat(actual2).containsExactly("1");
    }

    @Test
    void subString() {
        // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');
        // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
        // JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    }
}
