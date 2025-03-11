import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void shouldSplitCorrectly() {
        {
            String[] actual = "1,2".split(",");
            Assertions.assertThat(actual).containsExactly("1", "2");
        }

        {
            String[] actual = "1".split(",");
            Assertions.assertThat(actual).containsExactly("1");
        }
    }

    @Test
    void shouldTrimParentheses() {
        String input = "(1,2)";
        String actual = input.substring(1, input.length() - 1);
        Assertions.assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String#chatAt() 메서드는 문자열의 길이를 넘어가는 인덱스를 입력하면 IndexOutOfBoundsException을 발생시킨다.")
    void shouldThrowExceptionWhenIndexOutOfBounds() {
        String input = "abc";

        IndexOutOfBoundsException e = Assertions.catchThrowableOfType(() -> {
            input.charAt(100);
        }, IndexOutOfBoundsException.class);

        Assertions.assertThat(e)
            .hasMessageMatching("String index out of range: \\d+");
    }
}
