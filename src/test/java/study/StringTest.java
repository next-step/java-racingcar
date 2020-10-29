package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1","2");
    }

    @Test
    void splitOne() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void subStringTest(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).contains("1,2");
    }

    @Test
    void charAtTest() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(4);
            assertThat(result).isEqualTo('b');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 4");
    }




}
