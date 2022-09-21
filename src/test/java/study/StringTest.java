package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void split2() {
        final String target = "(1,2)";
        String result = target.substring(1, target.length() -1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    @Test
    void split3() {
        String target = "123";
        assertThatThrownBy(() -> {
            char ch = target.charAt(target.length());
            System.out.println(ch);
        }).hasMessageContaining("index out of range");
    }
}
