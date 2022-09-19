import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    private final String delimiter = ",";

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void testSplit1() {
        String given = "1,2";

        String[] expected = new String[]{"1", "2"};

        assertThat(given.split(delimiter)).contains(expected);
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void testSplit2() {
        String given = "1";

        String[] expected = new String[]{"1"};

        assertThat(given.split(delimiter)).containsExactly(expected);
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    void testSubString() {
        String given = "(1,2)";

        String expected = "1,2";

        assertThat(given.substring(1, 4)).isEqualTo(expected);
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 잘가져오는지 확인")
    void testCharAt1() {
        String given = "abc";

        char expected = 'b';

        assertThat(given.charAt(1)).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt() 메소드가 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    void testCharAt2() {
        String given = "abc";

        String expectedMessage = "range: " + given.length();

        assertThatThrownBy(() -> given.charAt(given.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(expectedMessage);
    }
}
