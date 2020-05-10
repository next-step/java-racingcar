package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);

        assertThat(result).startsWith("1").endsWith("2").isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 학습 테스트")
    void charAt() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    String data = "abc";
                    char result = data.charAt(4);
                }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
