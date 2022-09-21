import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void testSplit() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void testSubstring() {
        String target = "(1,2)";
        String result = target.substring(1, target.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt() 테스트")
    @Test
    void testCharAt() {
        String target = "12345";
        assertThat(target.charAt(0)).isEqualTo('1');
        assertThat(target.charAt(3)).isEqualTo('4');
        assertThatThrownBy(() -> target.charAt(target.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
