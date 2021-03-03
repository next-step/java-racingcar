package study;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split(){
        String[] test1 = "1,2".split(",");
        Assertions.assertThat(test1).containsExactly("1","2");

        String[] test2 = "1".split(",");
        Assertions.assertThat(test2).contains("1");
    }

    @Test
    void subString(){
        String test1 = "(1,2)".substring(0,4);
        Assertions.assertThat(test1).contains("1,2");
    }

    @Test
    void chatAt(){
        char test1 = "abc".charAt(1);
        Assertions.assertThat(test1).isEqualTo('b');
    }

    @Test
    @DisplayName("String Index Exception Test")
    void indexOutTest(){
        Assertions.assertThatThrownBy(()->{
            int length = "abc".length();
            char test1 = "abc".charAt(length+1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 4");
    }
}
