import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("문자열 split 메서드 테스트")
    public void split() {
        String target1 = "1,2";
        String[] target1SplitResults = target1.split(",");

        assertThat(target1SplitResults.length).isEqualTo(2);
        assertThat(target1SplitResults[0]).isEqualTo("1");
        assertThat(target1SplitResults[1]).isEqualTo("2");

        assertThat(target1SplitResults).contains("1", "2");
        assertThat(target1SplitResults).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 subString 메서드 테스트")
    public void subString() {
        String target = "(1,2)";
        String targetSubStringResults = target.substring(1, 4);

        assertThat(targetSubStringResults).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 chatAt 메서드 테스트")
    public void charAt() {
        String target = "abc";
        int targetLength = target.length();
        assertThatThrownBy(() -> target.charAt(targetLength)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
