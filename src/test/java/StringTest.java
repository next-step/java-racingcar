import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("split test")
    void test1() throws Exception {
        //given
        String input1 = "1,2";
        String input2 = "1";
        //when
        String[] result1 = input1.split(",");
        String[] result2 = input2.split(",");
        //then
        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).contains("1");
    }

    @Test
    @DisplayName("substring test")
    void test2() throws Exception {
        //given
        String input = "(1,2)";
        //when
        String result = input.substring(1, 4);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Occur IndexOutOfBoundsException test")
    void test3() throws Exception {
        //given
        String input = "abc";
        int idx = 5;
        //when
        assertThatThrownBy(() -> {
            input.charAt(idx);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + idx);
        //then
    }
}
