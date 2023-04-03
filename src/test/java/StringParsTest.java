import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringParsTest {

    private static final String DELIMITER = ",";

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되어야 한다.")
    void stringSplitTest1() {
        // Given & When
        String[] split = "1,2".split(DELIMITER);

        // Then
        assertThat(split[0]).isEqualTo("1");
        assertThat(split[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환해야 한다.")
    void stringSplitExactContains() {
        // Given & When
        final String[] split = "1".split(DELIMITER);

        // Then
        assertAll(
                () -> assertThat(split).containsExactly("1"),
                () -> assertThat(split).isInstanceOf(String[].class)
        );
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void stringSubstringExampleTest() {
        // Given
        final String value = "(1,2)";

        // When
        final String result = value.substring(1, value.length() - 1);

        // Then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다")
     void stringSubstringTest() {
        assertEquals("2", extractInnermostParentheses("(1,(2))"));
        assertEquals("1,2", extractInnermostParentheses("(1,2)"));
    }

    private String extractInnermostParentheses(String input) {
        Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    @ParameterizedTest
    @DisplayName("\"abc\" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    @CsvSource({
            "abc, 0, a",
            "abc, 1, b",
            "abc, 2, c"
    })
    void testCharAt(String str, int index, char expected) {
        char result = str.charAt(index);
        assertEquals(expected, result);
    }


    @Test
    @DisplayName("문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생")
    void testCharAtException() {
        // Given
        String str = "abc";

        // When & Then
        assertAll(
                () -> assertThatThrownBy(() -> str.charAt(3))
                        .isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: 3"),
                () -> assertThatThrownBy(() -> str.charAt(-1))
                        .isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: -1")
        );
    }


}
