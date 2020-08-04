import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1")
                .contains("2");

        result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    public void substring() {
        String value = "(1,2)";
        int beginIndex = value.indexOf("(");
        int endIndex = value.indexOf(")");

        String result = value.substring(beginIndex + 1, endIndex);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt 메소드 테스트")
    public void charAt() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("IndexOutOfBoundsException 발생 테스트")
    public void handleCharAtException() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abc".charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
