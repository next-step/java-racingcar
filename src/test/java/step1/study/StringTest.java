package step1.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("String.split()")
    void split() {
        String value1 = "1,2";
        assertThat(value1.split(",")).containsExactly("1", "2");

        String value2 = "1";
        assertThat(value2.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("String.substring()")
    void substring() {
        String value = "(1,2)";
        assertThat(value.substring(1, value.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt()")
    void charAt() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {value.charAt(3);}).
            isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
