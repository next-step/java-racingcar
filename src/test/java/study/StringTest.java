package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void splitStringsByComma() {
        final String input = "1,2";
        final String[] splitInput = input.split(",");

        assertThat(splitInput).containsExactly("1", "2");
    }

    @Test
    void splitSingleStringByComma() {
        final String input = "1";
        final String[] splitInput = input.split(",");

        assertThat(splitInput).containsExactly("1");
    }

    @Test
    void subString() {
        final String input = "(1,2)";
        final String subStringInput = input.substring(1, input.length() - 1);

        assertThat(subStringInput).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt 메서드를 통해 범위가 벗어나는 문자를 가져오는 경우 예외가 발생한다.")
    void getCharacterAtIndexOutOfRange() {
        final String input = "abc";
        final int indexOutOfRange = input.length();

        assertThatThrownBy(() -> input.charAt(indexOutOfRange))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
