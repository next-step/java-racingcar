package study;

import org.assertj.core.api.Assertions;
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
}
