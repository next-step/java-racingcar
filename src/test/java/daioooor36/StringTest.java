package daioooor36;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    void splitTest() {
        String input = "1,2";
        String[] results = input.split(",");

        assertThat(results).contains("2", "1");
        assertThat(results).containsExactly("1", "2");
        assertThat(results.length).isEqualTo(2);
        assertThat(results[0]).isEqualTo("1");
        assertThat(results[1]).isEqualTo("2");
    }
}
