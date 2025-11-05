import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @DisplayName(",를 기준으로 문자열을 split할 수 있다.")
    @Test
    public void splitByComma() {
        String input = "1,2";
        String delimiter = ",";

        String[] result = input.split(delimiter);

        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("substring을 활용하여 소괄호룰 제거할 수 있다.")
    @Test
    public void removeParentheses() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져올 수 있다")
    @ParameterizedTest
    @CsvSource({
            "0, a",
            "1, b",
            "2, c"
    })
    public void getChar(int index, char expected) {
        String input = "abc";

        assertThat(input.charAt(index)).isEqualTo(expected);
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    public void getCharOutOfBounds() {
        String input = "abc";
        int indexOutOfBounds = input.length();
        assertThatThrownBy(() -> input.charAt(indexOutOfBounds))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.valueOf(indexOutOfBounds));
    }
}
