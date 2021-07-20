package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result1 = getSplitByComma("1,2");
        assertThat(result1).contains("1");
        assertThat(result1).contains("2");

        String[] result2 = getSplitByComma("1");
        assertThat(result2).containsExactly("1");
    }

    private String[] getSplitByComma(String s) {
        return s.split(",");
    }
}
