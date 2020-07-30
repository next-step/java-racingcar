package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @Test
    @DisplayName("test split")
    public void testSplit() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("test substring")
    public void testSubstring() {
        String str = "(1,2)";
        int startBracket = str.indexOf("(");
        int lastBracket = str.lastIndexOf(")");
        assertThat("1,2".equals(str.substring(++startBracket,lastBracket))).isTrue();
    }

    @Test
    @DisplayName("Test charAt")
    public void charAt() {
        String str = "abc";
        // when
        Throwable thrown = catchThrowable(() -> {
            str.charAt(787);
        });
        assertThat(thrown)
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageMatching("String index out of range: \\d+");
    }
}