package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String problem = "(1, 2)";
        int openBracket = problem.indexOf('(');
        int closeBracket = problem.indexOf(')');
        String resultStr = problem.substring(openBracket + 1, closeBracket);
        Assertions.assertThat(resultStr).isEqualTo("1, 2");
    }

    @Test
    @DisplayName("유효하지 않은 위치의 스트링 값을 가져올 때 에러가 발생할 것이다.")
    void stringCharAt() {
        String problem = "abc";
        Assertions.assertThatThrownBy(() -> problem.charAt(problem.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
