package learning;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    public void split_with_comma() {
        String rawString = "1,2";
        String[] results = rawString.split(",");

        assertThat(results).contains("1", "2");
    }

    @Test
    public void split_without_comma() {
        String rawString = "1";
        String[] results = rawString.split(",");

        assertThat(results).containsExactly("1");
    }
}
