package step2.study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void splitRegexTest() {
        String[] result = "1:2,3".split("[,:]");
        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }
}
