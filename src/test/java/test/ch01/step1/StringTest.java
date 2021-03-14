package test.ch01.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {

    @Test
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");

    }

    @Test
    void removeParenthesis(){
        String str = "(1,2)";
        String result = str.substring(1,4);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("charAt() Method 범위 테스트")
    void getChar(){
        assertThatThrownBy(() -> {
            String str = "abc";
            char result = str.charAt(10);
            assertThat(result).isEqualTo('b');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 10");
    }

}
