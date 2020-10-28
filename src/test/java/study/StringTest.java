package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {
    @Test
    @DisplayName("1-1. 2개의 분리된 문자열이 모두 있는지 확인")
    public void splitIntoTwoString() {
        String origialStr = "1,2";

        String[] result = origialStr.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    @DisplayName("1-2. 콤마가 없을 때에도 문자열이 잘 분리되는지 확인")
    public void splitSingleString() {
        String originalStr = "1";

        String[] result = originalStr.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("2. 문자열에서 substring으로 () 제거하기")
    public void removeParanthesisAndSplit() {
        String originalStr = "(1,2)";

        String result = originalStr.substring(originalStr.indexOf("(") + 1, originalStr.indexOf(")"));

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("3-1. 문자열의 특정 위치의 문자 가져오기")
    public void getCharacterFromString() {
        String originalStr = "abc";

        assertThat(originalStr.charAt(0)).isEqualTo('a');
        assertThat(originalStr.charAt(1)).isEqualTo('b');
        assertThat(originalStr.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("3-2. 문자열의 특정 위치의 문자가 글자수를 넘었을 때")
    public void getCharacterFromStringWithInvalidIndex() {
        String originalStr = "abc";

        assertThatThrownBy(() -> {
            originalStr.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: 4");
    }
}
