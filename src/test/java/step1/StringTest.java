package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("String.split() 테스트")
    void stringTest1() {
        String[] multiDigitStrings = "1,2".split(",");

        assertThat(multiDigitStrings).contains("1");
        assertThat(multiDigitStrings).contains("2");

        assertThat(multiDigitStrings).containsExactly("1", "2");

        String[] singleDigitStrings = "1".split(",");

        assertThat(singleDigitStrings).containsExactly("1");
    }

    @Test
    @DisplayName("String.substring() 테스트")
    void stringTest2() {
        String strippedString = "(1,2)".substring(1,4);

        assertThat(strippedString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Exception 발생 테스트")
    void stringTest3() {
        String originalString = "abc";

        assertThat(originalString.charAt(1)).isEqualTo('b');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() ->originalString.charAt(3))
                .withMessageMatching("String index out of range: \\d+");

        assertThatThrownBy(() -> originalString.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range:");
    }
}
