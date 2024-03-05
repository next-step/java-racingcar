package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpringTest {

    @Test
    void split_test(){
        String [] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring_test(){
        String input = "(1,2)";
        String result = input.substring(1, input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 특정 위치 문자 반환")
    void charAt_test(){
        String input = "abc";
        char result = input.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열의 특정 위치 문자 반환_범위 예외 처리")
    void charAt_IndexOutOfBounds_test(){
        String input = "abc";
        final int INDEX = input.length()+1;
        assertThatThrownBy(()->{
            char result = input.charAt(INDEX);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: "+INDEX);
    }

}
