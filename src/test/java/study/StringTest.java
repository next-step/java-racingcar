package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("1,2 분리")
    void splitTwo(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("1, 분리")
    void splitOne(){
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 분리")
    void splitBracket(){
        String[] result = "(1,2)".substring(1,4).split(",");
        assertThat(result).containsExactly("1","2");
    }
}
