import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    void testSeparateByComma() {
        String input = "1,2,3";

        String[] result = input.split(",");

        assertThat(result).contains("1", "2", "3");
    }
}