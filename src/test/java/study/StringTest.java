package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("split 관련한 테스트")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("subString 관련한 테스트")
    @Test
    void subString() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).contains("1,2");
    }

    @DisplayName("문자열의 특정 위치를 가져온다.")
    @Test
    void charAt() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @DisplayName("특정 위치의 문자를 가져올때 위치 값을 벗어나면 "
                 + "StringIndexOutOfBoundsException 발생하는 부분을 확인한다.")
    @Test
    void charAtStringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            String str = "test";
            str.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageMatching("String index out of range: \\d+");

    }
}
