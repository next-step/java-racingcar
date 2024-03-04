package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    void split() {
        String[] division = "1,2".split(",");
        assertThat(division).containsExactly("1", "2");
    }
}
