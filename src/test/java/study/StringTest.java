package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - \"1,2\" 문자열이 주어지고 , 로 split했을 때 1과 2로 분리된 배열을 반환한다.")
    void split1() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항1 - \"1\" 문자열이 주어지고 , 로 split했을 때 1만을 포함하는 배열을 반환한다.")
    void split2() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 - \"(1,2)\" 문자열이 주어지고 subString() 메소드를 통해 () 를 제거하고 \"1,2\"를 반환한다.")
    void split3() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - \"abc\" 문자열이 주어지고 문자열 범위밖의 인덱스에 접근할 경우 StringIndexOutOfBoundsException 발생")
    void split4() {
        String data = "abc";

        assertThatThrownBy(() -> data.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
    }
}
