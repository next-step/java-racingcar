package pobiStringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] values = "3 + 4".split(" ");
        assertThat(values).containsExactly("3","+","4");
    }
}
