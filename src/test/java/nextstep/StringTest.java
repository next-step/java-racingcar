package nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("Splitting \"1,2\" by \",\" splits it into 1 and 2.")
    void splitWithComma() {
        String target = "1,2";

        String[] result = target.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("Splitting \"1\" by \",\" returns an array containing only 1.")
    void splitWithStringWithoutDelimiter() {
        String target = "1";

        String[] result = target.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("Given \"(1,2)\", utilize substring() to remove the \"()\" and return \"1,2\".")
    void substring() {
        String target = "(1,2)";

        String result = target.substring(1, target.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Given \"abc\", utilize charAt() to get the character at a specific location.")
    void charAt() {
        String target = "abc";

        assertThat(target.charAt(0)).isEqualTo('a');
        assertThat(target.charAt(1)).isEqualTo('b');
        assertThat(target.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("Given \"abc\", if the index is out of bounds when utilizing charAt(), StringIndexOutOfBoundsException is thrown.")
    void charAtWithIndexOutOfBounds() {
        String target = "abc";
        int indexOutOfBounds = target.length();

        assertThatThrownBy(() -> {
            target.charAt(indexOutOfBounds);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + indexOutOfBounds);
    }
}
