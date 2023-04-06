
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void splitTest() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substringTest() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 잘 가져온다.")
    void charAtSucceedTest() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("인덱스를 벗어나면 Exception 을 던진다. ")
    void charAtFailureTest() {
        String input = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(4);
                })
                .withMessageMatching("String index out of range: \\d+");
    }
}
