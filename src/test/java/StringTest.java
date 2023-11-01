import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitTest() {
        String splitString = "1,2";
        String[] splitResult = splitString.split(",");
        assertThat(splitResult).contains("1", "2");

        String noSplitString = "1";
        String[] noSplitResult = noSplitString.split(",");
        assertThat(noSplitResult).containsExactly("1");
    }

    @Test
    void substringTest() {
        String inputString = "(1,2)";
        String substringResult = inputString.substring(1,4);
        assertThat(substringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("위치 값을 벗어난 index를 charAt에 입력")
    void exceptionTest() {
        String inputString = "abc";
        char firstChar = inputString.charAt(0);
        char thirdChar = inputString.charAt(2);
        assertThat(firstChar).isEqualTo('a');
        assertThat(thirdChar).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char nonChar = inputString.charAt(10);
                }).withMessageMatching("String index out of range: 10");
    }
}