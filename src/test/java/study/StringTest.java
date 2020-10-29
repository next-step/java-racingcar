package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("문자열 입력 받았을 때 특정 위치 찾기")
    @Test
    void findCharacter() {
        String input = "abc";
        int findIndex = 0;

        char result = getCharacherFromString(input, findIndex);

        assertThat(result).isEqualTo('a');
    }

    private char getCharacherFromString(String input, int findIndex) {
        if (findIndex < 0 || findIndex > 2) {
            throw new StringIndexOutOfBoundsException(findIndex);
        }

        return input.charAt(findIndex);
    }
}
