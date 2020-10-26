package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split_comma_with_two_items() {
        String data = "1,2";
        String[] result = data.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1" ,"2");
    }

    @Test
    void split_comma_with_one_item() {
        String data = "1";
        String[] result = data.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }
}
