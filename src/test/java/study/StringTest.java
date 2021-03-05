package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @DisplayName("\"1,\"2를 ,로 split 했을 때 1과 2로 잘 분리된다.")
    @Test
    void splitNumbersWithComma() {
        // Arrange
        String source = "1,2";

        // Act
        String[] result = source.split(",");

        // Assert
        assertThat(result).contains("1", "2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    @Test
    void splitSingleNumberWithComma() {
        // Arrange
        String source = "1";

        // Act
        String[] result = source.split(",");

        // Assert
        assertThat(result).containsExactly("1");
    }

    @DisplayName("\"(1,2)\"에서 index 1부터 index 4까지 substring 하면 \"1,2\"가 반환된다.")
    @Test
    void removeParenthesisWithSubstring() {
        // Arrange
        String source = "(1,2)";

        // Act
        String result = source.substring(1, 4);

        // Assert
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("\"abc\"에서 charAt으로  요청하면  위치의 문자를 가져온다.")
    @Test
    void getSpecificCharacterWithCharAt() {
        // Arrange
        String source = "abc";

        // Act
        char result = source.charAt(1);

        // Assert
        assertThat(result).isEqualTo('b');
    }

    @DisplayName("index가 문자열 길이를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void charAtWithOutrangedIndexThrowsStringIndexOutOfBoundsException() {
        // Arrange
        String source = "abc";

        // Act & Assert
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> source.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
