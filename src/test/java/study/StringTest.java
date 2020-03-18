package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void req1_1() {
        assertThat(split("1,2")).containsExactly("1","2");
    }

    @Test
    void req1_2() {
        assertThat(split("1,")).containsExactly("1");
    }

    String[] split(String data) {
        return data.split(",");
    }

    @Test
    void req2() {
        String data = "(1,2)";
        String result = data.substring(data.indexOf("(")+1, data.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void req3_1() {
        String data = "abc";
        assertThat(getCharAt(data, 0)).isEqualTo('a');
        assertThat(getCharAt(data, 1)).isEqualTo('b');
        assertThat(getCharAt(data, 2)).isEqualTo('c');
    }

    @Test
    void req3_2() {
        String data = "abc";
        assertThatThrownBy(() -> { getCharAt(data, 4); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

    char getCharAt(String origin, int idx) {
        return origin.charAt(idx);
    }

    @Test
    @DisplayName("Step1. Require 3-3")
    void req3_3() {
        //
    }
}
