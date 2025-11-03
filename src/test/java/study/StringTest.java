package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt")
    void charAt() {
        String data = "abc";
        int index = 3;

        assertThatThrownBy(() -> data.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> data.charAt(index))
                .withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}
