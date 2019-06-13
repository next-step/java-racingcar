package daioooor36;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split_1() {
        String input = "1,2";
        String[] results = input.split(",");

        assertThat(results).contains("2", "1");
        assertThat(results).containsExactly("1", "2");
        assertThat(results.length).isEqualTo(2);
        assertThat(results[0]).isEqualTo("1");
        assertThat(results[1]).isEqualTo("2");
    }

    @Test
    void split_2() {
        String input = "(1,2)";
        String results = input.substring(1,input.length()-1);

        assertThat(results).isEqualTo("1,2");
    }

    @Test
    void split_3() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() ->
                "abc".charAt(4))
                .withMessageMatching("String index out of range: \\d+");
    }
}
