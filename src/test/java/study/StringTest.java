package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void remove_text() {
        String text = "(1,2)";
        String result = text.substring(1, text.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자 크기를 벗어나면 예외 발생")
    void exception_o() throws Exception{
        String text = "abc";
        int number = 3;
        if(number > text.length()-1){
            assertThatThrownBy(() -> {
                text.charAt(number);

            }).isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: %d", number);
        }

    }

}
