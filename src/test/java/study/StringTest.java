package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    void spring() {
        String[] result = "1,2".split(",");
        
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }
}
