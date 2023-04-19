package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    // 요구사항 1
    @Test
    void splitTest1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitTest2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    // 요구사항 2
    @Test
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    // 요구사항 3
    @Test
    @DisplayName("특정 위치의 문자를 가져오는지 확인")
    void charAtTest() {
        char charAt0 = "abc".charAt(0);
        char charAt1 = "abc".charAt(1);
        char charAt2 = "abc".charAt(2);

        assertThat(charAt0).isEqualTo('a');
        assertThat(charAt1).isEqualTo('b');
        assertThat(charAt2).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutBoundsException 발생")
    void charAtExceptionTest() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("out of range: 3");
    }
}
