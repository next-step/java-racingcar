package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
