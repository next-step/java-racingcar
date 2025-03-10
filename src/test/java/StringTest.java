import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열_테스트")
public class StringTest {

    @Test
    @DisplayName("문자열_자르기")
    void 문자열_자르기() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("괄호_제거")
    void 괄호_제거() {
        String str = "(1,2)";
        String leftParenthesis = "(";
        String rightParenthesis = ")";

        int startIndex = str.indexOf(leftParenthesis) + 1;
        int endIndex = str.indexOf(rightParenthesis);
        String result = str.substring(startIndex, endIndex);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치_문자_찾기")
    void 특정위치_문자_찾기() {
        String str = "abc";

        int length = str.length();

        assertThat(str.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> {
            str.charAt(length);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: " + length);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                str.charAt(-1);
            }).withMessageMatching("String index out of range: -?\\d+");
    }
}
