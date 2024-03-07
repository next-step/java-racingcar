package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split(){
        String data = "1,2";
        String[] result = data.split(",");

        assertThat(result).containsExactly("1","2");
    }

    @Test
    void split_char(){
        String data = "1";
        String[] result = data.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    void substring(){
        String data = "(1,2)";
        String result = data.substring(data.indexOf('('), data.indexOf(')'));

        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    void exception_test(){
        String data = "abc";

        assertThatThrownBy(() -> {
            char result = data.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}
