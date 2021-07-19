package study;

import org.junit.jupiter.api.Test;

import static  org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void split () {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void subString_요구사항2 () {
        String testDate = "(1,2)";
        String result = testDate.substring(1,4);
        assertEquals("1,2", result);
    }
    
}
