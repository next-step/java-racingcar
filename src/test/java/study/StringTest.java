package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String을 split 했을시 배열 검증")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("스트링에서 특정 문자 제외시켜서 밚환하기")
    void subString() {
        String problem = "(1, 2)";
        int openBracket = problem.indexOf('(');
        int closeBracket = problem.indexOf(')');
        String resultStr = problem.substring(openBracket + 1, closeBracket);
        assertThat(resultStr).isEqualTo("1, 2");
    }

    @Test
    @DisplayName("유효하지 않은 위치의 스트링 값을 가져올 때 에러가 발생할 것이다.")
    void stringCharAt() {
        String problem = "abc";

        // #1
        assertThatThrownBy(() -> problem.charAt(problem.length())).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");

        // #2
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> problem.charAt(problem.length())).withMessageMatching("String index out of range: \\d");
    }

}
