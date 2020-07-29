package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");

        result = "1,".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void substring() {
        String s = "(1,2)";
        int start = s.indexOf('(');
        int end = s.indexOf(')');
        String result = s.substring(start + 1, end);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void charAt() {
        String s = "abc";
        assertThat(s.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
    void charAtWithException() {
        String s = "abc";
        assertThatThrownBy(() -> {
            char c = s.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageMatching("Index: \\d+, Size: \\d+");
    }
}
