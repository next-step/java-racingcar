import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringUsesTest {

    @Test
    public void split() {
        String input = "1,2";
        String[] output = input.split(",");
        assertThat(output).contains("1");
        assertThat(output).containsExactly("1","2");
    }

    @Test
    public void substring() {
        String input = "(1,2)";
        String output = input.substring(1, input.length() -1);

        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("findByChar")
    public void charAt() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                input.charAt(100);
            });
            //.withMessage("Index: 2, Size: 2");
            //.withMessageMatching("Index; \\d+, Size: \\d+");
        assertThatCode(() -> {
           input.charAt(2);
        }).doesNotThrowAnyException();
    }
}
