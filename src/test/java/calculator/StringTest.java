package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
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
