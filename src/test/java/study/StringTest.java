package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("요구사항1")
    @Test
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @DisplayName("요구사항2")
    @Test
    void remove(){
        String number = "(1,2)".substring(1,4);
        assertThat(number).isEqualTo("1,2");
    }

    @DisplayName("요구사항3-1")
    @Test
    void charTest() {
        String chatTest = "abc";
        assertThat(chatTest.charAt(0)).isEqualTo('a');
        assertThat(chatTest.charAt(1)).isEqualTo('b');
        assertThat(chatTest.charAt(2)).isEqualTo('c');
    }

    @DisplayName("요구사항3-2")
    @Test
    void stringIndexExceptionTest(){
        String chatTest = "abc";
        assertThatThrownBy(() -> {chatTest.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + 4);
    }

}
