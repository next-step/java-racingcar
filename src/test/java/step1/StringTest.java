package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("'1,2'를 ,로 분리")
    void stringSplitByComma_1() {
        String parameter = "1,2";
        String[] splitStrings = parameter.split(",");

        assertThat(splitStrings.length).isEqualTo(2);
        assertThat(splitStrings).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 분리 했을 때 1만을 반환하는지")
    void stringSplitByComma_2() {
        String parameter = "1";
        String[] splitStrings = parameter.split(",");

        assertThat(splitStrings.length).isEqualTo(1);
        assertThat(splitStrings).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)'가 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환")
    void stringSplitByCommaRemoveBracket() {
        String parameter = "(1,2)";
        String removeBracket = parameter.substring(1, parameter.length() - 1);

        assertThat(removeBracket).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc'값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void stringsCharAtException() {
        String parameter = "abc";

        assertThat(parameter.charAt(2)).isEqualTo('c');
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> parameter.charAt(5)).withMessageMatching("String index out of range: \\d+");
    }
}