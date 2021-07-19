package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void name() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).containsExactly("1","2");
    }
}
