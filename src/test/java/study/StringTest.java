package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split(){
        String[] split = "1,2".split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }
}
