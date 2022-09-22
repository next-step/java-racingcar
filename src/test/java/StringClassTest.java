import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringClassTest {

    @Test
    @DisplayName("split() 메소드 테스트")
    void testSplit() {
        String testString1 = "1,2";
        String testString2 = "1";

        assertThat(testString1.split(",")).contains("1", "2");
        assertThat(testString2.split(",")).containsExactly("1");
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
        String testString = "abc";

        assertThat(testString.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 예외 케이스")
    void testChatAtFail() {
        String testString = "abc";

        assertThatThrownBy(() -> testString.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);

    }

}
