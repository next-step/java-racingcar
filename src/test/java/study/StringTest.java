package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void splitString(){
        String[] split = "1,2".split(",");
        assertThat(split).contains("1");
        assertThat(split).contains("2");
        assertThat(split).containsExactly("1","2");
    }
    @Test
    void substringTest(){
        String data = "(1,2)";
        String substring = data.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt Method Test")
    void charAtMethodTest(){
        String data = "abc";
        char c = data.charAt(0);
        assertThat(c).isEqualTo('a');

        int findCharIndex = 5;
        assertThatThrownBy(()->{
            data.charAt(findCharIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: "+findCharIndex);
    }



}
