package studytest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String input1 = "1,2";
        String input2 = "1";
        String comma = ",";

        String[] result1 = input1.split(comma);
        String[] result2 = input2.split(comma);

        assertThat(result1).contains("1", "2");
        assertThat(result1).containsExactly("1", "2");

        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void subString() {
        String input1 = "(1,2)";

        String result1 = input1.substring(1, input1.length() - 1);

        assertThat(result1).isEqualTo("1,2");
    }

    @Test
    @DisplayName("(charAt) valid index -> no exception")
    void charAt_validIndex() {
        String input1 = "abc";
        int validIndex = input1.length() - 1;

        assertThatCode(() -> {
            input1.charAt(validIndex);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("(charAt) invalid index -> throw exception")
    void charAt_invalidIndex() {
        String input1 = "abc";
        int invalidIndex = input1.length();

        assertThatThrownBy(() -> {
            input1.charAt(invalidIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }

}


