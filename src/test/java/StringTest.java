import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void testSplit() {
        final String input1 = "1,2";
        final String input2 = "1";
        final String splitter = ",";

        String[] result1 = input1.split(splitter);
        assertThat(result1).containsExactly("1", "2");

        String[] result2 = input2.split(splitter);
        assertThat(result2).containsExactly("1");
    }

    @Test
    public void testSubstring() {
        final String input = "(1,2)";

        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    public void testIndex() {
        final String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
    public void testStringIndexOutOfBoundsException() {
        final String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> input.charAt(input.length()));
    }
}
