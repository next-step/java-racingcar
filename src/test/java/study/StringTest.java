package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void split2(){
        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substring(){
        // given
        String result3 = "(1,2)";

        // when
        result3 = result3.substring(result3.indexOf("(")+1, result3.indexOf(")"));

        // then
        assertThat(result3).isEqualTo("1,2");
    }

    @DisplayName("String charAt Test")
    @Test
    void chatAt(){
        assertThatThrownBy(() ->{
            char result4 = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }

}

