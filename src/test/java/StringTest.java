import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    void testSeparateByComma() {
        String input = "1,2,3";

        String[] result = input.split(",");

        assertThat(result).contains("1", "2", "3");
    }

    @Test
    void testExtractStringFromBracket() {
        String input = "(1,2,3)";

        String result = input.substring(1, input.length() - 1);

        assertEquals("1,2,3", result);
    }
}