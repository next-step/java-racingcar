package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("split 테스트")
    void splitTest(){
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");
        assertThat(result1).contains("1","2");
        assertThat(result1).contains("1");
    }

    @Test
    @DisplayName("substring 테스트")
    void substringTest(){
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAtTest(){
        char a = "abc".charAt(0);
        char b = "abc".charAt(1);
        char c = "abc".charAt(2);
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
        assertThatThrownBy(()->{
           "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
