package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void split(){
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");

        assertThat(data).containsExactly("1", "2");
    }

    @Test
    public void split2(){
        String[] data = "1".split(",");
        assertThat(data).contains("1");

        assertThat(data).containsExactly("1");
    }

    @Test
    public void substring(){
        String data = "(1,2)";
        String result = data.substring(1, data.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("chatAt 테스트")
    @Test
    public void charAt(){
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() ->
            data.charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }

}
