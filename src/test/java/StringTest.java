import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringTest {

    private static final String REGEX_COMMA = ",";

    @Test
    void split1() {
        String[] num = "1,2".split(REGEX_COMMA);
        assertThat(num).contains("1", "2");
    }

    @Test
    void split2() {
        String[] num = "1".split(REGEX_COMMA);
        assertThat(num).containsExactly("1");
    }

    @Test
    void substring() {
        String s = "(1,2)".substring(1, 4);
        assertThat(s).isEqualTo("1,2");
    }

    @DisplayName("chatAt() 테스트 케이스 : 정상 케이스")
    @ParameterizedTest(name = "{index} : index {0}의 값은 {1}이다")
    @CsvSource(value = {
            "0 , a",
            "1 , b",
            "2 , c"
    })
    void charAt1(int index, char expectedResult) {
        char c = "abc".charAt(index);
        assertThat(c).isEqualTo(expectedResult);
    }

    @DisplayName("charAt() 테스트 케이스 : 실패 케이스 -> String size < index 경우, StringIndexOutOfBoundsException 발생")
    @Test
    void charAt2() {
        String abc = "abc";
        int outOfIndex = abc.length() + 1;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            abc.charAt(outOfIndex);
        }).withMessageContaining("String index out of range");
    }
}
