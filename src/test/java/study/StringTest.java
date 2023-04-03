package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    void splitTwoValues() {
        //GIVEN
        String src = "1,2";


        //WHEN
        String[] result = src.split(",");

        //THEN
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitOneValue() {
        //GIVEN
        String src = "1,";

        //WHEN
        String[] result = src.split(",");

        //THEN
        assertThat(result).containsExactly("1");
    }

    @Test
    void substringParentheses() {
        //GIVEN
        String src = "(1,2)";

        //WHEN
        String result = src.substring(1, src.length() - 1);

        //THEN
        assertThat(result).isEqualTo("1,2");
    }
}
