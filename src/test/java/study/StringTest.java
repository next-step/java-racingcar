package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1").contains("2");
        assertThat(result).containsExactly("1","2");
    }
    @Test
    public void subString(){
        String result = "(1,2)".substring(1,5);
        assertThat(result).contains("1,2");
    }
    @Test
    public void chatAt(){
        String result = "abc";
        assertThatThrownBy(() -> {
            result.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
