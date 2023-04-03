import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항1")
    public void 요구사항1(){
        String input1 = "1,2";

        String[] result = input1.split(",");
        String[] expected = {"1","2"};

        assertThat(result).containsExactly(expected);

        String input2 = "1";

        result = input2.split(",");
        expected = new String[]{"1"};

        assertThat(result).containsExactly(expected);
    }

    @Test
    @DisplayName("요구사항2")
    public void 요구사항2(){
        //given
        String input = "(1,2)";

        String expected = "1,2";
        String result = input.substring(1, 4);
        //when

        //then
        assertThat(result).contains(expected);
    }

    @Test
    @DisplayName("요구사항3")
    public void 요구사항3(){
        //given
        String input = "abc";
        //when
        char expected = 'b';
        char result = input.charAt(1);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("요구사항3_exception")
    public void 요구사항3_exception(){
        //given
        String input = "abcdef";
        int index = 10;
        //when
        assertThatThrownBy(()->{
            input.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
        //then
    }
}
