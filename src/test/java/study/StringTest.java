package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    void split() {
        String[] division = "1,2".split(",");
        assertThat(division).containsExactly("1", "2");

        String[] word = "1".split(",");
        assertThat(word).containsExactly("1");
    }


    @Test
    void substring() {
        String word = "(1,2)".substring(1, 4);
        assertThat(word).isEqualTo("1,2");
    }
}
