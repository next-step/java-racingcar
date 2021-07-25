package stringCalc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringUsesTest {

    @ParameterizedTest
    @ValueSource(strings = "1,2")
    public void split(String input) {
        String[] output = input.split(",");
        assertThat(output).contains("1");
        assertThat(output).containsExactly("1","2");
    }

    @ParameterizedTest
    @ValueSource(strings = "(1,2)")
    public void substring(String input) {
        String output = input.substring(1, input.length() -1);

        assertThat(output).isEqualTo("1,2");
    }

    @ParameterizedTest
    @ValueSource(strings = "abc")
    @DisplayName("findByChar")
    public void charAt(String input) {

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
