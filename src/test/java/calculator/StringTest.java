package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("split 동작 Test")
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).hasSize(2);
        assertThat(values).containsExactly("1","2");

        values = "1".split(",");
        assertThat(values).hasSize(1);
        assertThat(values).containsExactly("1");
    }
}
