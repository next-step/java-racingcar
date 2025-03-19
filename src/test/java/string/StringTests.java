package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 요구사항 1.
 */
public class StringTests {
    @Test
    @DisplayName("\"1,2\"를 분리하면 \"1\"과 \"2\"를 포함하는 배열이 생성된다")
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1,\"을 분리하면 \"1\"만 포함하는 배열이 생성된다")
    void splitOne() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\"을 분리하면 ()를 제외하고 \"1\", \"2\"만 포함하는 배열이 생성된다")
    void splitWithoutParentheses() {
        assertThat("(1,2)".replaceAll("[()]", "").split(",")).containsExactly("1", "2");
    }
}
