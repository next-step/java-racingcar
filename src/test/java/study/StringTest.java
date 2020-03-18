package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");

        result = "1".split(",");
        assertThat(result).contains("1");

        String subStr = "(1,2)";
        assertThat(subStr.substring(1, subStr.length()-1)).contains("1,2");


        
    }
}
