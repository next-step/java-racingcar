package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String [] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");

    }

    @Test
    void subString(){
        String result = "(1,2)";
        assertThat(result.substring(1,4)).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String result = "abc";
        assertThatThrownBy(() -> {
            result.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("에러");
    }
}
