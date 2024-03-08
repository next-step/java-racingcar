package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("String method Test")
public class StringUtilsTest {

    @DisplayName("split 메서드 동작 테스트")
    @Test
    public void split() {
        String text = "1,2";

        String[] result = text.split(",");

        assertThat(result).contains("1", "2");
    }

    @DisplayName("substring 메서드 동작 테스트")
    @Test
    public void substring() {
        String text = "(1,2)";

        String result = text.substring(1, text.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드 동작 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0,a","1,b","2,c"})
    public void charAt(int index, char expect) {
        String text = "abc";

        char result = text.charAt(index);

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("charAt 메서드 범위 초과 테스트")
    @Test
    public void charAtExceptionTest() {
        String text = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> text.charAt(4))
                .withMessageMatching("String index out of range: \\d+");
    }
}
