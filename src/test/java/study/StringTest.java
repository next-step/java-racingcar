package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    void split2() {
        assertThat("1".split(",")).contains("1");
    }

    @Test
    void subString() {
        String input = "(1,2)";
        String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 문자 위치가 문자열 범위를 벗어난 경우 IndexOutOfBoundsException")
    void charAt(){
        String input = "abc";
        int outboundIndex = input.length();
        assertThatThrownBy(() -> {
            input.charAt(outboundIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
