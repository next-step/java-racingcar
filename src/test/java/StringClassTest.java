import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringClassTest {

    @Test
    @DisplayName("split() 메소드 테스트")
    void testSplit() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("subString() 메소드 테스트")
    void testSubString() {
        String testString = "(1,2)";

        assertThat(testString.substring(1, testString.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 성공 케이스")
    void testCharAtSuccess() {
        assertThat("abc".charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 예외 케이스")
    void testChatAtFail() {
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
