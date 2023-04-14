package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitStringNumbers() {
        String inputString = "1,2";
        String[] splitedString = inputString.split(",");

        String[] expectedResult = {"1", "2"};
        assertThat(splitedString).containsExactly(expectedResult);
    }

    @Test
    void splitStringNumber() {
        String inputString = "1,";

        String[] splitedString = inputString.split(",");
        String[] expectedResult = {"1"};
        assertThat(splitedString).containsExactly(expectedResult);
    }

    @Test
    void subStringNumbersWithParentheses() {
        String inputString = "(1,2)";

        String subtractedString = inputString.substring(1, 4);
        String expectedResult = "1,2";
        assertThat(subtractedString).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Test to get the character at a specific index using the charAt function")
    void charAtString() {
        String inputString = "ABC";

        char secondIndexCharacter = inputString.charAt(1);
        char expectedResult = 'B';
        assertThat(secondIndexCharacter).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Test for StringIndexOutOfException by throwing out of index")
    void charAtStringHasOccurredStringIndexOutOfException() {
        assertThatThrownBy(() -> {
            "TEST".charAt(4);
        }).isExactlyInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index 4 out of bounds for length 4");
    }
}
