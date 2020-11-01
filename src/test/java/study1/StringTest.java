package study1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void request1(){
        String[] input = "1,2".split(",");
        assertThat(input).contains("1");
        assertThat(input).containsExactly("1", "2");
    }

    @Test
    void request2(){
        String answer = "(1,2)".substring(1,4);
        assertThat(answer).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAtTest")
    void request3(){
        String inputText = "abc";
        assertThatThrownBy(() -> {
            char result= inputText.charAt(1);
            result = inputText.charAt(2);
            result = inputText.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageMatching("String index out of range: \\d+");;
    }
}
