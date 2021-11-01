package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * .
 */
public class StringTest {

    @Test
    @DisplayName("요구사항 1")
    void requirement01() {
        String oneTwo = "1,2";
        String[] splitOneTwo = oneTwo.split(",");
        assertThat(splitOneTwo).contains("1", "2");

        String one = "1";
        String[] splitOne = one.split(",");
        assertThat(splitOne).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void requirement02() {
        String str = "(1,2)";
        String s1 = str.replaceAll("\\(", "");
        String s2 = s1.replaceAll("\\)", "");
        assertThat(s2).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3- StringIndexOutOfBoundsException 발생 테스트")
    void requirement03() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }

}
