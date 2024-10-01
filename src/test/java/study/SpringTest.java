package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
//        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).contains("1,2");
    }
}
