package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpringTest {
    @Test
    @DisplayName("when split \"1,2\", check contains 1" +
                 "when split \"1,2\", check contains 1, 2")
    void testRequirement1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("when input is \"(1,2)\", check return \"1,2\"")
    void testRequirement2() {
        String input = "(1,2)";
        int startIndex = input.indexOf('(') + 1;
        int endIndex = input.indexOf(')');
        String result = input.substring(startIndex, endIndex);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("when input is 'abc', test 'charAt' Exception1")
    void testRequirement3_1() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 3");
    }

    @Test
    @DisplayName("when input is 'abc', test 'charAt' Exception2")
    void testRequirement3_2() {
        String input = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(3);
                })
                .withMessage("String index out of range: 3");
    }
}
