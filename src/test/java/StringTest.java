import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 split 했을 때 1과 2로 분리된다")
    void splitMulti() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1").contains("2");
    }

    @Test
    @DisplayName("\"1\"을 split 했을 때 1만을 포함하는 배열이 반환된다")
    void splitSingle() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 \"1,2\" 이 반환된다")
    void substring() {
        String input = "(1,2)";

        String result = input.substring(1, input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
    void charAt(int index, char expected) {
        String input = "abc";

        char actual = input.charAt(index);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 예외가 발생한다")
    void charAtOutOfIndex() {
        String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(input.length()))
                .withMessageMatching("String index out of range: \\d+");
    }
}