package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).containsExactly("1", "2");

        String[] split = "1".split(",");
        Assertions.assertThat(split).containsExactly("1");
    }

}
