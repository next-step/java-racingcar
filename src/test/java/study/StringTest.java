package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("요구사항 1")
    void 요구사항1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");

        String[] result2 = "1".split(",");
        assertThat(result2).contains("1");
    }

}
