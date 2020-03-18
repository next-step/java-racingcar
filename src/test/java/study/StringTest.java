package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    public void string_test() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
        String[] numberOne = "1".split(",");
        assertThat(numberOne).contains("1");
    }

    @Test
    public void eliminate_brace_test() {
        //given
        String source = "(1,2)";
        //when
        String result = source.substring(1, 4);
        //then
        assertThat(result).isEqualTo("1,2");
    }
}
