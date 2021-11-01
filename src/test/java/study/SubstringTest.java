package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubstringTest {
    @Test
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }
}
