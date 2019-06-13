package learn;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@Tag("learn")
class StringLearnTest {

    @Test
    void split() {

        final String delimiter = ",";

        String commaSeparatedString1 = "1" + delimiter + "2";
        assertThat(commaSeparatedString1.split(delimiter)).containsExactly("1", "2");

        String commaSeparatedString2 = "1" + delimiter;
        assertThat(commaSeparatedString2.split(delimiter)).containsExactly("1");
    }

    @Test
    void substring() {

        String string = "(1,2)";

        assertThat(string.substring(1, string.length() - 1)).isEqualTo("1,2");
    }

    @Test
    void charAt() {

        String string = "abc";

        assertThat(string.charAt(0)).isEqualTo('a');
        assertThat(string.charAt(1)).isEqualTo('b');
        assertThat(string.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> string.charAt(3))
                .withMessage("String index out of range: 3");
    }
}
