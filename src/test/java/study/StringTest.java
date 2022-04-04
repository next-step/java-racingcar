package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void splitArray01() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitArray02() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        int totalLength = data.length();
        int beginIndex = 1;
        int endIndex = totalLength - 1;

        String result = data.substring(beginIndex, endIndex);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    @Test
    void charAt() {
        String data = "abc";
        int normalIndex = 2;

        assertThat(data.charAt(normalIndex)).isEqualTo('c');

    }

    @DisplayName("특정 위치의 문자를 가져오는 테스트로 인덱스를 벗어나면 예외가 발생된다.")
    @Test
    void charAtOutOfIndex() {
        String data = "abc";
        int oddIndex = 5;

        assertThatThrownBy(() -> {
            data.charAt(oddIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
