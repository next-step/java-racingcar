package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    void spllit() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1","2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    String subString() {
        String result = "1,2".substring(0);
        result = result.substring(-1);

        assertThat(result).isEqualTo("1,2");

        return result;
    }



}
