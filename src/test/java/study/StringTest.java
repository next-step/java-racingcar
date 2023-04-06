package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {


    @Test
    @DisplayName("split()을 이용한 문자열 자르기")
    void split_테스트() {
        assertThat("1,2".split(",")).contains("1");
        assertThat("1".split(",")).contains("1");
        assertThat("1,".split(",")).contains("1");
    }

    @Test
    @DisplayName("substring()을 이용한 문자열 자르기")
    void substring_테스트() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드의 StringIndexOutOfBoundsException 발생 테스트")
    void charAt_테스트() {
        String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(input.length()));
    }
}
