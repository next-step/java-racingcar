package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("split 메소드는 매개값으로 받은 구분자로 String을 분리한다.")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @DisplayName("split 메소드는 String에 매개값으로 받ㅇ느 구분자가 없으면 크기 1의 String 배열을 반환한다.")
    @Test
    void splitSingle() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("subString 메소드는 매개값으로 받은 index를 기준으로 자른 부분 문자열을 반환한다.")
    @Test
    void subString() {
        String source = "(1,2)";
        String result = source.substring(1, source.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드는 String의 특정 위치의 문자를 반환한다.")
    @Test
    void charAt() {
        String source = "abc";
        char result = source.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @DisplayName("charAt 메소드는 String 길이의 위치를 벗어나면 Exception을 던진다.")
    @Test
    void charAtThrown() {
        String source = "abc";
        assertThatThrownBy(() -> source.charAt(source.length())
        ).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");
    }
}
